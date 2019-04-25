package com.zjj.mvpdemo.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.zjj.mvpdemo.R;
import com.zjj.mvpdemo.contract.Contract;
import com.zjj.mvpdemo.model.WordModel;
import com.zjj.mvpdemo.presenter.CheesePresenter;
import com.zjj.mvpdemo.util.CheeseSearchEngine;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;
import io.reactivex.functions.Predicate;

public class CheeseActivity extends BaseActivity {

    private CheesePresenter mCheesePresenter = new CheesePresenter("http://120.79.229.78/zjj/");

    private EditText mQueryEditText;
    private Button mSearchButton;
    private CheeseAdapter mAdapter;
    private ProgressBar mProgressBar;

    @Override
    protected Contract.Presenter createPresenter() {
        return mCheesePresenter;
    }

    @Override
    protected void init() {
        setContentView(R.layout.activity_cheeses);

        RecyclerView list = (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(mAdapter = new CheeseAdapter());

        mQueryEditText = (EditText) findViewById(R.id.query_edit_text);
        mSearchButton = (Button) findViewById(R.id.search_button);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);


        Observable<String> buttonClickStream = createButtonClickObservable();
        Observable<String> textChangeStream = createTextChangeObservable();

        mCheesePresenter.search(buttonClickStream, textChangeStream);
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess(WordModel model) {
        //从网络返回的数据
        mCheesePresenter.mCheeseSearchEngine = new CheeseSearchEngine(model, "");
    }

    @Override
    public void onError(String result) {
        Toast.makeText(CheeseActivity.this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showResult(List<String> result) {
        if (result.isEmpty()) {
            Toast.makeText(this, R.string.nothing_found, Toast.LENGTH_SHORT).show();
            mAdapter.setCheeses(Collections.<String>emptyList());
        } else {
            mAdapter.setCheeses(result);
        }
    }

    private Observable<String> createButtonClickObservable() {

        return Observable.create(new ObservableOnSubscribe<String>() {

            @Override
            public void subscribe(final ObservableEmitter<String> emitter) throws Exception {
                mSearchButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        emitter.onNext(mQueryEditText.getText().toString());
                    }
                });

                emitter.setCancellable(new Cancellable() {
                    @Override
                    public void cancel() throws Exception {
                        mSearchButton.setOnClickListener(null);
                    }
                });
            }
        });
    }

    private Observable<String> createTextChangeObservable() {

        Observable<String> textChangeObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(final ObservableEmitter<String> emitter) throws Exception {

                final TextWatcher watcher = new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        emitter.onNext(s.toString());
                    }
                };

                mQueryEditText.addTextChangedListener(watcher);

                emitter.setCancellable(new Cancellable() {
                    @Override
                    public void cancel() throws Exception {
                        mQueryEditText.removeTextChangedListener(watcher);
                    }
                });
            }
        });

        return textChangeObservable
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String query) throws Exception {
                        return query.length() >= 2;
                    }
                }).debounce(1000, TimeUnit.MILLISECONDS);  // add this line
    }
}

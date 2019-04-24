package com.zjj.mvpdemo.module.view;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zjj.mvpdemo.R;
import com.zjj.mvpdemo.module.model.WordModel;
import com.zjj.mvpdemo.module.presenter.WordPresenter;

import java.util.List;

public class MainActivity extends BaseActivity {

    private WordPresenter mWordPresenter = new WordPresenter("https://api.douban.com/v2/");

    private TextView textView;
    private Button button;

    @Override
    protected WordPresenter createPresenter() {
        return mWordPresenter;
    }

    @Override
    protected void init() {
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.search_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWordPresenter.getSearch("金瓶梅", null, 0, 1);
            }
        });
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void onSuccess(WordModel model) {
        textView.setText(model.toString());
    }

    @Override
    public void onError(String result) {
        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showResult(List<String> result) {

    }

}

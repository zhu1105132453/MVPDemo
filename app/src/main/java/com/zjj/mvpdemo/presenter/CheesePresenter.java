package com.zjj.mvpdemo.presenter;

import android.content.Intent;

import com.zjj.mvpdemo.model.WordModel;
import com.zjj.mvpdemo.retrofit.RxManager;
import com.zjj.mvpdemo.util.CheeseSearchEngine;
import com.zjj.mvpdemo.MyApplication;
import com.zjj.mvpdemo.R;
import com.zjj.mvpdemo.contract.Contract;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class CheesePresenter implements Contract.Presenter {

    private WordModel mWordModel;
    private String mBaseUrl;
    private CompositeDisposable disposables;//管理网络订阅
    private RxManager manager;
    private Disposable mDisposable;//管理按键订阅
    private Contract.View view;
    public CheeseSearchEngine mCheeseSearchEngine;

    public CheesePresenter() {
        //加载本地数据
        List<String> cheeses = Arrays.asList(MyApplication.getAppContext().getResources().getStringArray(R.array.cheeses));
        mCheeseSearchEngine = new CheeseSearchEngine(cheeses);
    }

    public CheesePresenter(String mBaseUrl) {
        this.mBaseUrl = mBaseUrl;
    }

    @Override
    public void onCreate() {
        if (null != mBaseUrl) {
            manager = new RxManager(mBaseUrl);
        }
        if (null == disposables) {
            disposables = new CompositeDisposable();
        }
        //加载网络数据
        getSearch();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        if (!mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
        if (null != disposables && disposables.isDisposed()) {
            disposables.clear();
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(Contract.View view) {
        this.view = view;
    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    public void search(Observable textChangeStream, Observable buttonClickStream) {
        mDisposable = Observable.merge(textChangeStream, buttonClickStream)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        view.showProgressBar();
                    }
                })
                .observeOn(Schedulers.io())
                .map(new Function<String, List<String>>() {
                    @Override
                    public List<String> apply(String query) {
                        return mCheeseSearchEngine.search(query);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> result) {
                        view.hideProgressBar();
                        view.showResult(result);
                    }
                });
    }


    public void getSearch() {
        manager.getSearch()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WordModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onNext(WordModel wordModel) {
                        mWordModel = wordModel;
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        view.onError("请求失败！！");
                    }

                    @Override
                    public void onComplete() {
                        if (view != null) {
                            view.onSuccess(mWordModel);
                        }
                    }
                });
    }

}

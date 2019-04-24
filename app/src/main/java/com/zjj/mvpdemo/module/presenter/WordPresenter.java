package com.zjj.mvpdemo.module.presenter;

import android.content.Intent;

import com.zjj.mvpdemo.RxManager;
import com.zjj.mvpdemo.module.contract.Contract;
import com.zjj.mvpdemo.module.model.WordModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WordPresenter implements Contract.Presenter {

    private WordModel mWordModel;
    private CompositeDisposable disposables;
    private RxManager manager;
    private Contract.View view;
    private String mBaseUrl;

    public WordPresenter(String baseUrl) {
        mBaseUrl = baseUrl;
    }

    @Override
    public void onCreate() {
        manager = new RxManager(mBaseUrl);
        if (null == disposables) {
            disposables = new CompositeDisposable();
        }
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
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

    public void getSearch(String name, String tag, int start, int count) {
        manager.getSearch(name, tag, start, count)
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

package com.zjj.mvpdemo.module.presenter;

import android.content.Intent;

import com.zjj.mvpdemo.module.contract.Contract;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class CheesePresenter implements Contract.Presenter {

    private Disposable mDisposable;
    private Contract.View view;

    @Override
    public void onCreate() {
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        if (!mDisposable.isDisposed()) {
            mDisposable.dispose();
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

    public void setmDisposable(Disposable mDisposable) {
        this.mDisposable = mDisposable;
    }

    public Observable search(Observable textChangeStream, Observable buttonClickStream) {
        return Observable.merge(textChangeStream, buttonClickStream);
    }
}

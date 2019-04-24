package com.zjj.mvpdemo.module.contract;

import android.content.Intent;

import com.zjj.mvpdemo.module.model.WordModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public interface Contract {
    interface Model {

    }

    interface View {

        void showProgressBar();

        void hideProgressBar();

        void onSuccess(WordModel model);

        void onError(String result);

        void showResult(List<String> result);
    }

    interface Presenter {

        void onCreate();

        void onStart();

        void onStop();

        void pause();

        void attachView(View view);

        void attachIncomingIntent(Intent intent);
    }
}

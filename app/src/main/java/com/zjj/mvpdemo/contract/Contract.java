package com.zjj.mvpdemo.contract;

import android.content.Intent;

import com.zjj.mvpdemo.model.WordModel;

import java.util.List;

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

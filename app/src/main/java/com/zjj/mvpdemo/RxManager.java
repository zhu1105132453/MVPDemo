package com.zjj.mvpdemo;

import com.zjj.mvpdemo.module.retrofit.RetrofitHelper;
import com.zjj.mvpdemo.module.retrofit.RetrofitService;

import io.reactivex.Observable;

public class RxManager {
    private RetrofitService mRetrofitService;

    private Observable mObservable;

    public RxManager() {

    }

    public RxManager(String baseUrl) {
        LogUtils.d("123", baseUrl);
        this.mRetrofitService = RetrofitHelper.getInstance().create(RetrofitService.class, baseUrl);
    }

    public Observable getSearch(String name, String tag, int start, int count) {
        return mRetrofitService.search();
    }

  /*  public void setmCheeseSearch(Observable textChangeStream, Observable buttonClickStream) {
        mObservable = Observable.merge(textChangeStream, buttonClickStream);
    }

    public Observable getSearch(String cheese){
        return mObservable;
    }*/
}

package com.zjj.mvpdemo.retrofit;

import com.zjj.mvpdemo.util.LogUtils;

import io.reactivex.Observable;

public class RxManager {
    private RetrofitService mRetrofitService;

    public RxManager(String baseUrl) {
        LogUtils.d("123", baseUrl);
        this.mRetrofitService = RetrofitHelper.getInstance().create(RetrofitService.class, baseUrl);
    }

    public Observable getSearch() {
        return mRetrofitService.search();
    }

}

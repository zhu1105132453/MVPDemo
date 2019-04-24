package com.zjj.mvpdemo.module.retrofit;

import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    private static int DEFAULT_TIMEOUT = 5;

    private RetrofitHelper() {

    }

    public static RetrofitHelper getInstance() {

        return RetrofitManagerHolder.INSTANCE;
    }

    private static class RetrofitManagerHolder {

        private static RetrofitHelper INSTANCE = new RetrofitHelper();
    }

    public <S> S create(Class<S> service, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(service);
    }

    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .proxy(Proxy.NO_PROXY)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .build();
    }
}
package com.zjj.mvpdemo.module.retrofit;

import com.zjj.mvpdemo.module.contract.Contract;
import com.zjj.mvpdemo.module.model.WordModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("music/2337701")
    Observable<WordModel> search();
}

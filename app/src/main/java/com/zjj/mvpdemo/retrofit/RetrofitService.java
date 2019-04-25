package com.zjj.mvpdemo.retrofit;

import com.zjj.mvpdemo.model.WordModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("test")
    Observable<WordModel> search();
}

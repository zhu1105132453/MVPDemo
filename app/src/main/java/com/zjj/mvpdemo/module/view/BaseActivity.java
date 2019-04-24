package com.zjj.mvpdemo.module.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zjj.mvpdemo.module.contract.Contract;

public abstract class BaseActivity<T extends Contract.Presenter> extends AppCompatActivity implements Contract.View {

    private T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        init();
    }

    protected void initPresenter() {
        mPresenter = createPresenter();
        mPresenter.onCreate();
        mPresenter.onStart();
        //绑定生命周期
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onStop();
        }
    }

    /**
     * 创建一个Presenter
     *
     * @return
     */
    protected abstract T createPresenter();

    protected abstract void init();

}

package com.captain.wds.myapplication.mvp.framework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.captain.wds.myapplication.mvp.MvpPresenter;
import com.captain.wds.myapplication.mvp.MvpView;
import com.captain.wds.myapplication.mvp.framework.support.ActivityMvpDelegate;
import com.captain.wds.myapplication.mvp.framework.support.ActivityMvpDelegateImpl;
import com.captain.wds.myapplication.mvp.framework.support.MvpDelegateCallback;


//第一重代理——》生命周期代理（代理对象——持有目标对象）
//第二重代理——》P层代理（目标对象——实现目标接口）
public abstract class MvpActivity<V extends MvpView, P extends MvpPresenter<V>> extends AppCompatActivity implements MvpView, MvpDelegateCallback<V, P> {

    private P presenter;

    private ActivityMvpDelegate<V, P> mvpDelegate;

    private ActivityMvpDelegate<V, P> getMvpDelegate() {
        if (mvpDelegate == null) {
            mvpDelegate = new ActivityMvpDelegateImpl<V, P>(this);
        }
        return mvpDelegate;
    }

    /* ===============第二重代理================= */
        @Override public P createPresenter() {
        return presenter;
    }

    @Override public P getPresenter() {
        return presenter;
    }

    @Override public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    @Override public V getMvpView() {
        return (V) this;
    }
    /*===============end=================*/

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onCreate(savedInstanceState);

    }

    @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        getMvpDelegate().onRestoreInstanceState(savedInstanceState);
    }

    @Override protected void onStart() {
        super.onStart();
        getMvpDelegate().onStart();
    }

    @Override protected void onResume() {
        super.onResume();
        getMvpDelegate().onResume();
    }

    @Override protected void onPause() {
        super.onPause();
        getMvpDelegate().onPause();
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getMvpDelegate().onSaveInstanceState(outState);

    }

    @Override protected void onStop() {
        super.onStop();
        getMvpDelegate().onStop();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        getMvpDelegate().onDestroy();
    }
}

package com.captain.wds.myapplication.mvp.framework.support;

import android.os.Bundle;

import com.captain.wds.myapplication.mvp.MvpPresenter;
import com.captain.wds.myapplication.mvp.MvpView;


/**
 * Created by wudongsheng on 2018/6/30.
 */
//第一重代理——》生命周期（目标接口）
public interface ActivityMvpDelegate <V extends MvpView,P extends MvpPresenter<V>>{
    void onCreate(Bundle savedInstanceState);

    void onRestoreInstanceState(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onPause();

    void onSaveInstanceState(Bundle outState);

    void onStop();

    void onDestroy();


}

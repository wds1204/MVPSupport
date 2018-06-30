package com.captain.wds.myapplication.mvp.framework.support;

import android.os.Bundle;

import com.captain.wds.myapplication.mvp.MvpPresenter;
import com.captain.wds.myapplication.mvp.MvpView;

/**
 * Created by wudongsheng on 2018/6/30.
 */
// 第一重代理——》生命周期（目标对象——实现目标接口）
public class ActivityMvpDelegateImpl<V extends MvpView, P extends MvpPresenter<V>> implements ActivityMvpDelegate<V, P> {

	private ProxyMvpDelegateCallback<V, P> mvpCallback;

	// 双重代理的关联
	public ActivityMvpDelegateImpl(MvpDelegateCallback<V, P> mvpDelegateCallback) {
		mvpCallback = new ProxyMvpDelegateCallback<V, P>(mvpDelegateCallback);
	}

	@Override public void onCreate(Bundle savedInstanceState) {
		mvpCallback.createPresenter();
		mvpCallback.attachView();

	}

	@Override public void onRestoreInstanceState(Bundle savedInstanceState) {

	}

	@Override public void onStart() {

	}

	@Override public void onResume() {

	}

	@Override public void onPause() {

	}

	@Override public void onSaveInstanceState(Bundle outState) {

	}

	@Override public void onStop() {

	}

	@Override public void onDestroy() {
		mvpCallback.detachView();

	}
}

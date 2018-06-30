package com.captain.wds.myapplication.mvp.framework.support.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.captain.wds.myapplication.mvp.MvpPresenter;
import com.captain.wds.myapplication.mvp.MvpView;
import com.captain.wds.myapplication.mvp.framework.support.MvpDelegateCallback;
import com.captain.wds.myapplication.mvp.framework.support.ProxyMvpDelegateCallback;


/**
 * Created by wudongsheng on 2018/6/30.
 */

public class FragmentMvpDelegateImpl<V extends MvpView, P extends MvpPresenter<V>> implements FragmentMvpDelegate<V, P> {

	private ProxyMvpDelegateCallback<V, P> proxyMvpCallback;

	public FragmentMvpDelegateImpl(MvpDelegateCallback<V, P> mvpCallback) {
		this.proxyMvpCallback = new ProxyMvpDelegateCallback<>(mvpCallback);

	}

	@Override public void onAttach(Context context) {

	}

	@Override public void onCreate(Bundle savedInstanceState) {

	}

	@Override public void onActivityCreated(Bundle savedInstanceState) {

	}

	@Override public void onViewCreated(View view, Bundle savedInstanceState) {
		this.proxyMvpCallback.createPresenter();
		this.proxyMvpCallback.attachView();
	}

	@Override public void onStart() {

	}

	@Override public void onPause() {

	}

	@Override public void onResume() {

	}

	@Override public void onStop() {

	}

	@Override public void onDestroyView() {
		this.proxyMvpCallback.detachView();
	}

	@Override public void onDestroy() {

	}

	@Override public void onSaveInstanceState(Bundle outState) {

	}

	@Override public void onDetach() {

	}
}

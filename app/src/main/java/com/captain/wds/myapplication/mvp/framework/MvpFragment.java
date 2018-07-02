package com.captain.wds.myapplication.mvp.framework;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.captain.wds.myapplication.mvp.MvpPresenter;
import com.captain.wds.myapplication.mvp.MvpView;
import com.captain.wds.myapplication.mvp.framework.support.MvpDelegateCallback;
import com.captain.wds.myapplication.mvp.framework.support.fragment.FragmentMvpDelegate;
import com.captain.wds.myapplication.mvp.framework.support.fragment.FragmentMvpDelegateImpl;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wudongsheng on 2018/6/30.
 */

// 第一重代理——》生命周期代理（代理对象——持有目标对象）
// 第二重代理——》P层代理（目标对象——实现目标接口）
public abstract class MvpFragment<V extends MvpView, P extends MvpPresenter<V>> extends Fragment implements MvpView, MvpDelegateCallback<V, P> {

	// 持有目标对象引用
	protected FragmentMvpDelegate<V, P>	mvpDelegate;

	protected View						rootView;

	private Unbinder					bind;

	private boolean						isInit	= false;

	protected FragmentMvpDelegate<V, P> getMvpDelegate() {
		if (this.mvpDelegate == null) {
			this.mvpDelegate = new FragmentMvpDelegateImpl<V, P>(this);
		}
		return this.mvpDelegate;
	}

	/* ================第二重代理================ */
	private P presenter;

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
	/* ===============end================= */

	@Override public void onAttach(Context context) {
		super.onAttach(context);
		getMvpDelegate().onAttach(context);
	}

	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getMvpDelegate().onCreate(savedInstanceState);
	}

	@Override public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		getMvpDelegate().onActivityCreated(savedInstanceState);
	}

	@Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		if (rootView == null) rootView = inflater.inflate(getLayoutResource(), container, false);
		bind = ButterKnife.bind(this, rootView);
		ViewGroup parent = (ViewGroup) rootView.getParent();
		if (parent != null) {
			parent.removeView(rootView);

		}
		return rootView;
	}

	@Override public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		getMvpDelegate().onViewCreated(view, savedInstanceState);
		if (!isInit) {
			isInit = true;
			initData();
		}

	}

	@Override public void onStart() {
		super.onStart();
		getMvpDelegate().onStart();
	}

	@Override public void onPause() {
		super.onPause();
		getMvpDelegate().onPause();
	}

	@Override public void onResume() {
		super.onResume();
		getMvpDelegate().onResume();
	}

	@Override public void onStop() {
		super.onStop();
		getMvpDelegate().onStop();
	}

	@Override public void onDestroyView() {
		super.onDestroyView();
		getMvpDelegate().onDestroyView();
	}

	@Override public void onDestroy() {
		super.onDestroy();
		getMvpDelegate().onDestroy();
		bind.unbind();

	}

	@Override public void onDetach() {
		super.onDetach();
		getMvpDelegate().onDetach();
	}

	@Override public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		getMvpDelegate().onSaveInstanceState(outState);
	}

	/* ===============abstract================= */

	// 获取布局文件
	protected abstract int getLayoutResource();

	protected abstract void initData();

}

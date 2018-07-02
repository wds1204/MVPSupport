package com.captain.wds.myapplication.mvp.framework.lce.fragment;

import android.os.Bundle;
import android.view.View;

import com.captain.wds.myapplication.mvp.MvpPresenter;
import com.captain.wds.myapplication.mvp.framework.MvpFragment;
import com.captain.wds.myapplication.mvp.framework.lce.MvpLceView;
import com.captain.wds.myapplication.mvp.framework.lce.impl.MvpLceViewImpl;

public  abstract class MvpLceFragment<D, V extends MvpLceView<D>, P extends MvpPresenter<V>> extends MvpFragment<V, P> implements MvpLceView<D> {

	private MvpLceViewImpl<D> lceViewImpl;

	private MvpLceViewImpl<D> getLceViewImpl() {
		if (lceViewImpl == null) {
			lceViewImpl = new MvpLceViewImpl<>();
		}
		return lceViewImpl;
	}

	private void initLceView(View view) {
		lceViewImpl.initView(view);
		lceViewImpl.setOnClickErrorListener(new View.OnClickListener() {

			@Override public void onClick(View v) {
				onErrorClick(v);
			}
		});
	}

	public void onErrorClick(View v) {
		// 重新加载
		loadData(false);
	}

	@Override public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		getLceViewImpl();
		initLceView(view);

	}

	@Override public void loadData(boolean isPullToRefresh) {
		getLceViewImpl().loadData(isPullToRefresh);
	}

	@Override public void showLoading(boolean isPullToRefresh) {
		getLceViewImpl().showLoading(isPullToRefresh);
	}

	@Override public void showContent() {
		getLceViewImpl().showContent();
	}

	@Override public void bindData(D data) {
		getLceViewImpl().bindData(data);
	}

	@Override public void showError(Throwable e, boolean pullToRefresh) {

		getLceViewImpl().showError(e, pullToRefresh);

	}
}

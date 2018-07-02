package com.captain.wds.myapplication.mvp.framework.lce.impl;

import android.view.View;

import com.captain.wds.myapplication.R;
import com.captain.wds.myapplication.common.WdsCheckUtils;
import com.captain.wds.myapplication.mvp.framework.lce.ILceAnimator;
import com.captain.wds.myapplication.mvp.framework.lce.MvpLceView;
import com.captain.wds.myapplication.mvp.framework.lce.impl.animator.DefaultLceAnimator;

/**
 * @author wds_captain
 * @date 2018/7/1
 * @email:wdsmyhome@hotmail.com
 */
public class MvpLceViewImpl<D> implements MvpLceView <D>{

	// 处理动画
	private ILceAnimator	animator;

	// 加载View
	private View			contentView;

	private View			loadingView;

	private View			errorView;

	public void setAnimator(ILceAnimator animator) {
		this.animator = animator;
	}

	private ILceAnimator getAnimator() {
		if (this.animator == null) {
			this.animator = new DefaultLceAnimator();
		}
		return animator;
	}

	public void initView(View rootView) {

		WdsCheckUtils.checkNotNull(rootView, "root view 不能给为空");

		if (loadingView == null) {
			this.loadingView = rootView.findViewById(R.id.loadingView);
		}
		if (contentView == null) {
			this.contentView = rootView.findViewById(R.id.contentView);
		}
		if (errorView == null) {
			this.errorView = rootView.findViewById(R.id.errorView);
		}
		WdsCheckUtils.checkNotNull(loadingView, "loadingView 不能给为空");
		WdsCheckUtils.checkNotNull(contentView, "contentView 不能给为空");
		WdsCheckUtils.checkNotNull(errorView, "errorView 不能给为空");

	}

	public void setOnClickErrorListener(View.OnClickListener onClickListener) {
		if (this.errorView != null) {
			this.errorView.setOnClickListener(onClickListener);
		}
	}

	@Override public void loadData(boolean isPullToRefresh) {

	}

	@Override public void showLoading(boolean isPullToRefresh) {
		if (!isPullToRefresh) {
			getAnimator().showLoadingView(loadingView, contentView, errorView);
		}
	}

	@Override public void showContent() {
		getAnimator().showContentView(loadingView, contentView, errorView);

	}


	@Override public void bindData(D data) {

	}

	@Override public void showError(Throwable e, boolean pullToRefresh) {

		if (!pullToRefresh) {
			getAnimator().showErrorView(loadingView, contentView, errorView);
		}

	}

}

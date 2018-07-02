package com.captain.wds.myapplication.mvp.framework.lce.impl.animator;

import android.view.View;

import com.captain.wds.myapplication.mvp.framework.lce.ILceAnimator;

/**
 * @author:wds_captain
 * @date :2018/7/1
 * @email :wdsmyhome@hotmail.com
 * @desc : 提供默认动画策略
 */
public class DefaultLceAnimator implements ILceAnimator {

	@Override public void showLoadingView(View loadingView, View contentView, View errorView) {
		AnimatorUtils.getInstance().showLoading(loadingView, contentView, errorView);

	}

	@Override public void showContentView(View loadingView, View contentView, View errorView) {
		AnimatorUtils.getInstance().showContent(loadingView, contentView, errorView);

	}

	@Override public void showErrorView(View loadingView, View contentView, View errorView) {

		AnimatorUtils.getInstance().showError(loadingView, contentView, errorView);

	}
}

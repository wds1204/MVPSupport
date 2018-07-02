package com.captain.wds.myapplication.mvp.framework.lce;

import android.view.View;

/**
 * @author:wds_captain
 * @date :2018/7/1
 * @email :wdsmyhome@hotmail.com
 * @desc : 加载动画、错误动画、内容动画
 */
public interface ILceAnimator {

	/**
	 * 加载页面
	 *
	 * @param loadingView
	 * @param contentView
	 * @param errorView
	 */
	void showLoadingView(View loadingView, View contentView, View errorView);

	/**
	 * 内容页面
	 *
	 * @param loadingView
	 * @param contentView
	 * @param errorView
	 */
	void showContentView(View loadingView, View contentView, View errorView);

	/**
	 * 错误页面
	 *
	 * @param loadingView
	 * @param contentView
	 * @param errorView
	 */
	void showErrorView(View loadingView, View contentView, View errorView);

}

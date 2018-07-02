package com.captain.wds.myapplication.mvp.framework.lce;

import com.captain.wds.myapplication.mvp.MvpView;

/**
 * @author wds_captain
 * @date 2018/7/1
 * @email:wdsmyhome@hotmail.com
 */
// LCE设计——》(代理模式 目标接口)
public interface MvpLceView<D> extends MvpView {

	/**
	 * 加载数据
	 * 
	 * @param isPullToRefresh
	 *            是否是下拉刷新
	 */
	void loadData(boolean isPullToRefresh);

	/**
	 * 显示加载页面
	 * 
	 * @param isPullToRefresh
	 */
	void showLoading(boolean isPullToRefresh);

	/**
	 * 成功->更新UI层（显示内容View）
	 */
	void showContent();

	/**
	 * 绑定数据
	 */
	void bindData(D data);

	/**
	 * 失败->显示错误页面
	 */
	void showError(Throwable e, boolean pullToRefresh);

}

package com.captain.wds.myapplication.mvp.framework.support;


import com.captain.wds.myapplication.mvp.MvpPresenter;
import com.captain.wds.myapplication.mvp.MvpView;

/**
 * Created by wudongsheng on 2018/6/30.
 */
// 第二重代理——》P层的代理（目标接口）
public interface MvpDelegateCallback<V extends MvpView, P extends MvpPresenter<V>> {

	P createPresenter();

	P getPresenter();

	void setPresenter(P presenter);

	V getMvpView();

}

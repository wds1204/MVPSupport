package com.captain.wds.myapplication.mvp;

//抽象中介者
public interface MvpPresenter<V extends MvpView> {

	void attachView(V view);

	void detachView();

	//增加业务->销毁功能(例如：网络请求停止、数据库查询停止等等...)
	void destory();

}

package com.captain.wds.myapplication.mvp;

//抽象中介者
public interface MvpPresenter<V extends MvpView> {

	void attachView(V view);

	void detachView();

}

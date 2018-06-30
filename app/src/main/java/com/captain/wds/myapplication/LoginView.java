package com.captain.wds.myapplication;


import com.captain.wds.mvpdemo.mvp.MvpView;

//V层->抽象同事B
public interface LoginView extends MvpView {

	void onLoginResult(String result);

}

package com.captain.wds.myapplication;


import com.captain.wds.myapplication.mvp.framework.MvpBasePresenter;

//具体中介
public class LoginPresenter extends MvpBasePresenter<LoginView> {

	// 持有同事引用
	// 两个同事：M层、V层
	private LoginModel model;

	public LoginPresenter() {
		this.model = new LoginModel();
	}

	public void login(String username, String password) {
		String loginState = this.model.login(username, password);
		this.getView().onLoginResult(loginState);

	}

}

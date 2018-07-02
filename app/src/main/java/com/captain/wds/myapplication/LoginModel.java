package com.captain.wds.myapplication;


import com.captain.wds.myapplication.mvp.MvpModel;

//M层->具体同事A
public class LoginModel implements MvpModel {

	public String login(String username, String password) {
		if (username.equals("wds") && password.equals("123456")) {
			return "登陆成功";
		} else {
			return "登陆失败";
		}

	}

}

package com.captain.wds.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.captain.wds.myapplication.mvp.framework.MvpActivity;

/**
 * 
 * @author wds-captain
 * @date 2018/7/1
 */
public class MainActivity extends MvpActivity<LoginView,LoginPresenter> implements LoginView {


	private EditText		et_name;

	private EditText		et_password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e("TAG", "onCreate======");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.e("TAG", "onRestart======");
	}

	@Override public int getLayoutId() {
		return R.layout.activity_main;
	}

	@Override protected void initView() {
		et_name = findViewById(R.id.et_name);
		et_password = findViewById(R.id.et_password);
		findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {

			@Override public void onClick(View v) {
				getPresenter().login(et_name.getText().toString(), et_password.getText().toString());
			}
		});
	}

	@Override protected void initData() {

	}

	@Override public LoginPresenter createPresenter() {
		return new LoginPresenter();
	}

	@Override public void onLoginResult(String result) {
		Log.e("TAG", "result :" + result);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.e("TAG", "onSaveInstanceState======");
	}
}

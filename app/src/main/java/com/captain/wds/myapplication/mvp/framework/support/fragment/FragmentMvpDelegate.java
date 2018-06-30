package com.captain.wds.myapplication.mvp.framework.support.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.captain.wds.myapplication.mvp.MvpPresenter;
import com.captain.wds.myapplication.mvp.MvpView;

/**
 * Created by wudongsheng on 2018/6/30.
 */

public interface FragmentMvpDelegate<V extends MvpView, P extends MvpPresenter<V>> {

	void onAttach(Context context);

	void onCreate(Bundle savedInstanceState);

	void onActivityCreated(Bundle savedInstanceState);

	void onViewCreated(View view, Bundle savedInstanceState);

	void onStart();

	void onPause();

	void onResume();

	void onStop();

	void onDestroyView();

	void onDestroy();

	void onSaveInstanceState(Bundle outState);

	void onDetach();
}

package com.captain.wds.myapplication.mvp.framework.support;

import android.app.Activity;
import android.os.Bundle;

import com.captain.wds.myapplication.common.WdsCheckUtils;
import com.captain.wds.myapplication.mvp.MvpPresenter;
import com.captain.wds.myapplication.mvp.MvpView;
import com.captain.wds.myapplication.mvp.framework.support.manager.PresenterManager;

import java.util.UUID;

/**
 * Created by wudongsheng on 2018/6/30.
 */
// 第一重代理——》生命周期（目标对象——实现目标接口）
public class ActivityMvpDelegateImpl<V extends MvpView, P extends MvpPresenter<V>> implements ActivityMvpDelegate<V, P> {

	private static final String				KEY_VIEW_ID	= "com.captain.wds.myapplication.mvp.framework.support.id";

	private ProxyMvpDelegateCallback<V, P>	mvpCallback;

	private boolean							keepPresenterInstance;													// 表示是否创建新的对象

	private String							viewId;

	protected Activity						activity;

	// 双重代理的关联
	public ActivityMvpDelegateImpl(Activity activity, MvpDelegateCallback<V, P> mvpDelegateCallback, boolean keepPresenterInstance) {
		this.activity = activity;
		mvpCallback = new ProxyMvpDelegateCallback<V, P>(mvpDelegateCallback);
		this.keepPresenterInstance = keepPresenterInstance;
	}

	@Override public void onCreate(Bundle bundle) {

		P presenter = null;
		// P层的缓存
		if (bundle != null && keepPresenterInstance) {
			viewId = bundle.getString(KEY_VIEW_ID);
			if (viewId == null) {
				presenter = createViewIdAndCreatePresenter();
			}
		} else {
			presenter = createViewIdAndCreatePresenter();
		}
		// 绑定P
		mvpCallback.setPresenter(presenter);
		// 绑定V
		mvpCallback.attachView();

	}

	private P createViewIdAndCreatePresenter() {
		P presenter = mvpCallback.createPresenter();
		WdsCheckUtils.checkNotNull(presenter, "presenter不能为空");
		if (keepPresenterInstance) {
			viewId = UUID.randomUUID().toString();
			PresenterManager.putPresenter(activity, viewId, presenter);
		}
		return presenter;
	}

	@Override public void onRestoreInstanceState(Bundle savedInstanceState) {

	}

	@Override public void onStart() {

	}

	@Override public void onResume() {

	}

	@Override public void onPause() {

	}

	@Override public void onSaveInstanceState(Bundle outState) {

		if (viewId != null && keepPresenterInstance) {
			// 缓存viewId
			outState.putString(KEY_VIEW_ID, viewId);
		}

	}

	@Override public void onStop() {

	}

	// 是否存在这个实例(不存在要销毁->返回false，存在返回true不需要销毁)
	static boolean retainPresenterInstance(boolean keepPresenterInstance, Activity activity) {
		return keepPresenterInstance && (activity.isChangingConfigurations() || !activity.isFinishing());
	}

	@Override public void onDestroy() {

		boolean retainPresenterInstance = retainPresenterInstance(keepPresenterInstance, activity);

		mvpCallback.detachView();

		// 同时P层也需要销毁
		if (!retainPresenterInstance) {
			mvpCallback.destory();
		}

		if (!retainPresenterInstance && viewId != null) {
			PresenterManager.remove(activity, viewId);
		}

	}
}

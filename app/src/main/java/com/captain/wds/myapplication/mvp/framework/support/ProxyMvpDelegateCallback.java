package com.captain.wds.myapplication.mvp.framework.support;


import com.captain.wds.myapplication.mvp.MvpPresenter;
import com.captain.wds.myapplication.mvp.MvpView;

/**
 * Created by wudongsheng on 2018/6/30.
 */
// 第二重代理——》P层代理（代理对象——持有目标对象，实现目标接口）
public class ProxyMvpDelegateCallback<V extends MvpView, P extends MvpPresenter<V>> implements MvpDelegateCallback<V, P> {

	// 持有目标对象的引用，————————实际上就是MvpActivity
	private MvpDelegateCallback<V, P> mvpCallback;

	public ProxyMvpDelegateCallback(MvpDelegateCallback<V, P> mvpCallback) {
		this.mvpCallback = mvpCallback;
	}

	@Override public P createPresenter() {
		P presenter = this.mvpCallback.getPresenter();
		if (presenter == null) {
			presenter = this.mvpCallback.createPresenter();
		}
		if (presenter == null) {
			throw new NullPointerException("P层不能为空");
		}
		this.setPresenter(presenter);
		return presenter;
	}

	@Override public P getPresenter() {
		return this.mvpCallback.getPresenter();
	}

	@Override public void setPresenter(P presenter) {
		this.mvpCallback.setPresenter(presenter);
	}

	@Override public V getMvpView() {
		return this.mvpCallback.getMvpView();
	}

	/* ===============添加两个重要的方法——绑定和解绑================= */
	public void attachView() {
		getPresenter().attachView(getMvpView());
	}

	public void detachView() {
		getPresenter().detachView();
	}
}

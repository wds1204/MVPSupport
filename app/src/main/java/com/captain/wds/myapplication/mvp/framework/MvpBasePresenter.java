package com.captain.wds.myapplication.mvp.framework;


import com.captain.wds.myapplication.mvp.MvpPresenter;
import com.captain.wds.myapplication.mvp.MvpView;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//实现具体绑定
public class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {

	private V view;

	public V getView() {
		return view;
	}

	@Override public void attachView(V view) {
		this.view = view;
		Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(), new ProxyInvocationHandler(view));
	}

	@Override public void detachView() {
		this.view = null;
	}

	class ProxyInvocationHandler<V extends MvpView> implements InvocationHandler {

		private V view;

		public ProxyInvocationHandler(V view) {

			this.view = view;

		}

		@Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if (view == null) {
				throw new NullPointerException("空异常");
			}
			return method.invoke(proxy, args);
		}
	}

}

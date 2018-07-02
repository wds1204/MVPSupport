package com.captain.wds.myapplication.mvp.framework.lce.impl;

import android.view.View;

import com.captain.wds.myapplication.R;
import com.captain.wds.myapplication.mvp.MvpPresenter;
import com.captain.wds.myapplication.mvp.MvpView;
import com.captain.wds.myapplication.mvp.framework.MvpActivity;
import com.captain.wds.myapplication.mvp.framework.lce.ILceAnimator;
import com.captain.wds.myapplication.mvp.framework.lce.MvpLceView;

/**
 * @author wds_captain
 * @date 2018/7/1
 * @email:wdsmyhome@hotmail.com
 */
// LCE设计——代理对象
public abstract class MvpLceActivity<D, V extends MvpView, P extends MvpPresenter<V>> extends MvpActivity<V, P> implements MvpLceView<D> {

	private MvpLceViewImpl<D> mvpLceView;

	private MvpLceViewImpl getMvpLceView() {
		if (mvpLceView == null) {
			mvpLceView = new MvpLceViewImpl<>();
		}
		return mvpLceView;
	}

	@Override public void onContentChanged() {
		super.onContentChanged();
		getMvpLceView().initView(findViewById(R.id.rootView));
		getMvpLceView().setOnClickErrorListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                onErrorClick(v);
            }
        });
	}
    public void onErrorClick(View v){
        //重新加载
        loadData(false);
    }

	public void setLceAnimator(ILceAnimator lceAnimator){
		getMvpLceView().setAnimator(lceAnimator);
	}

	@Override public void loadData(boolean isPullToRefresh) {

		getMvpLceView().loadData(isPullToRefresh);

	}

	@Override public void showLoading(boolean isPullToRefresh) {
		getMvpLceView().showLoading(isPullToRefresh);

	}

	@Override public void showContent() {
		getMvpLceView().showContent();
	}

	@Override public void bindData(D data) {
		getMvpLceView().bindData(data);

	}

	@Override public void showError(Throwable e, boolean pullToRefresh) {

		getMvpLceView().showError(e, pullToRefresh);

	}
}

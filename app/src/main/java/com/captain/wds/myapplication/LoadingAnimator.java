package com.captain.wds.myapplication;


import android.support.annotation.NonNull;
import android.view.View;

import com.captain.wds.myapplication.mvp.framework.lce.impl.animator.DefaultLceAnimator;
import com.captain.wds.myapplication.view.LoadingView;



public class LoadingAnimator extends DefaultLceAnimator {

    private LoadingView loading;

    @Override
    public void showLoadingView(View loadingView, View contentView, View errorView) {
        super.showLoadingView(loadingView, contentView, errorView);
        loading = (LoadingView) loadingView.findViewById(R.id.lv_loading);
        loading.openAnimation();
    }

    @Override
    public void showContentView(View loadingView, View contentView, @NonNull View errorView) {
        if (loading != null){
            loading.closeAnimation();
        }
        loadingView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
        contentView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showErrorView(@NonNull View loadingView, @NonNull View contentView, View errorView) {
        super.showErrorView(loadingView, contentView, errorView);
        if (loading != null){
            loading.closeAnimation();
        }
        loadingView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
        contentView.setVisibility(View.GONE);
    }
}

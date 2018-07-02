package com.captain.wds.myapplication.mvp.framework.lce.impl.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.view.View;

import com.captain.wds.myapplication.R;

/**
 * @author:wds_captain
 * @date :2018/7/1
 * @email :wdsmyhome@hotmail.com
 * @desc :
 */
public class AnimatorUtils {

	private static AnimatorUtils instance;

	public static AnimatorUtils getInstance() {
		if (instance == null) {
			synchronized (AnimatorUtils.class) {
				if (instance == null) {
					instance = new AnimatorUtils();
				}
			}
		}
		return instance;
	}

	public void showLoading(View loadingView, View contentView, View errorView) {
		contentView.setVisibility(View.GONE);
		errorView.setVisibility(View.GONE);
		loadingView.setVisibility(View.VISIBLE);
	}

	public void showContent(final View loadingView, final View contentView, View errorView) {
		if (contentView.getVisibility() == View.VISIBLE) {
			loadingView.setVisibility(View.GONE);
			errorView.setVisibility(View.GONE);
		} else {
			errorView.setVisibility(View.GONE);
			Resources resources = loadingView.getResources();

			AnimatorSet animatorSet = new AnimatorSet();
			int translateInPixels = resources.getDimensionPixelSize(R.dimen.lce_content_view_animation_translate_y);
			/* ===============content动画================= */
			ObjectAnimator contentAlpha = ObjectAnimator.ofFloat(contentView, "alpha", 0f, 1f);
			ObjectAnimator contentTranslateIn = ObjectAnimator.ofFloat(contentView, "translationY", translateInPixels, 0);
			/* ===============loading动画================= */
			ObjectAnimator loadingFadeOut = ObjectAnimator.ofFloat(loadingView, "alpha", 1f, 0f);
			ObjectAnimator loadingTranslateOut = ObjectAnimator.ofFloat(loadingView, "translationY", 0, -translateInPixels);

			animatorSet.playTogether(contentAlpha, contentTranslateIn, loadingFadeOut, loadingTranslateOut);
			animatorSet.setDuration(resources.getInteger(R.integer.lce_content_view_show_animation_time));

			animatorSet.addListener(new AnimatorListenerAdapter() {

				@Override public void onAnimationEnd(Animator animation) {


					loadingView.setVisibility(View.GONE);
					loadingView.setAlpha(1f); // For future showLoading calls
					contentView.setTranslationY(0);
					loadingView.setTranslationY(0);
				}

				@Override public void onAnimationStart(Animator animation) {
					contentView.setTranslationY(0);
					loadingView.setTranslationY(0);
					contentView.setVisibility(View.VISIBLE);
				}
			});
			animatorSet.start();

		}

	}

	public void showError(final View loadingView, View contentView, final View errorView) {

		contentView.setVisibility(View.GONE);

		final Resources resources = loadingView.getResources();
		// Not visible yet, so animate the view in
		AnimatorSet set = new AnimatorSet();
		ObjectAnimator in = ObjectAnimator.ofFloat(errorView, "alpha", 1f);
		ObjectAnimator loadingOut = ObjectAnimator.ofFloat(loadingView, "alpha", 0f);

		set.playTogether(in, loadingOut);
		set.setDuration(resources.getInteger(R.integer.lce_error_view_show_animation_time));

		set.addListener(new AnimatorListenerAdapter() {

			@Override public void onAnimationStart(Animator animation) {
				super.onAnimationStart(animation);
				errorView.setVisibility(View.VISIBLE);
			}

			@Override public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
				loadingView.setVisibility(View.GONE);
				loadingView.setAlpha(1f); // For future showLoading calls
			}
		});

		set.start();

	}

}

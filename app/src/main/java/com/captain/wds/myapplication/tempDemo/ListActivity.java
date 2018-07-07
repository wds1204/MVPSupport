package com.captain.wds.myapplication.tempDemo;

import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.captain.wds.myapplication.LoadingAnimator;
import com.captain.wds.myapplication.R;
import com.captain.wds.myapplication.mvp.framework.lce.MvpLceView;
import com.captain.wds.myapplication.mvp.framework.lce.impl.MvpLceActivity;

import butterknife.BindView;

public class ListActivity extends MvpLceActivity<PostModel, MvpLceView<PostModel>, ListPresenter> implements SwipeRefreshLayout.OnRefreshListener {

	@BindView(R.id.recyclerview) RecyclerView		recyclerview;

	@BindView(R.id.contentView) SwipeRefreshLayout	swipeRefreshLayout;

	@Override public int getLayoutId() {
		return R.layout.activity_list;
	}

	@Override protected void initView() {
		recyclerview.setLayoutManager(new LinearLayoutManager(this));
		recyclerview.setAdapter(new RecyclerView.Adapter() {

			@NonNull @Override public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
				View view = LayoutInflater.from(ListActivity.this).inflate(R.layout.list_item, parent, false);

				return new RecyViewHolder(view);
			}

			@Override public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {}

			@Override public int getItemCount() {
				return 10;
			}

			class RecyViewHolder extends RecyclerView.ViewHolder {

				public RecyViewHolder(View itemView) {
					super(itemView);
				}
			}
		});

		setLceAnimator(new LoadingAnimator());

		swipeRefreshLayout.setOnRefreshListener(this);

	}

	@Override protected void initData() {
		loadData(false);

	}

	@Override public ListPresenter createPresenter() {
		return new ListPresenter();
	}

	@Override public void loadData(boolean isPullToRefresh) {
		super.loadData(isPullToRefresh);
		getPresenter().getListData(isPullToRefresh);
	}

	@Override public void onRefresh() {
		loadData(true);
	}

	@Override public void bindData(PostModel data) {
		super.bindData(data);
	}

	@Override public void showContent() {
		super.showContent();
		swipeRefreshLayout.setRefreshing(false);

	}
}

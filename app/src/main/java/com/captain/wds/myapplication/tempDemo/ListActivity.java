package com.captain.wds.myapplication.tempDemo;

import android.annotation.SuppressLint;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.captain.wds.myapplication.LoadingAnimator;
import com.captain.wds.myapplication.R;
import com.captain.wds.myapplication.mvp.framework.lce.MvpLceView;
import com.captain.wds.myapplication.mvp.framework.lce.impl.MvpLceActivity;

import butterknife.BindView;

public class ListActivity extends MvpLceActivity<PostModel, MvpLceView<PostModel>, ListPresenter> implements SwipeRefreshLayout.OnRefreshListener {

	@BindView(R.id.listview) ListView				listview;

	@BindView(R.id.contentView) SwipeRefreshLayout	swipeRefreshLayout;

	@Override public int getLayoutId() {
		return R.layout.activity_list;
	}

	@Override protected void initView() {
		listview.setAdapter(new BaseAdapter() {

			@Override public int getCount() {
				return 10;
			}

			@Override public Object getItem(int position) {
				return null;
			}

			@Override public long getItemId(int position) {
				return 0;
			}

			@SuppressLint("ViewHolder") @Override public View getView(int position, View convertView, ViewGroup parent) {
				ViewHolder holder = null;

				if (holder == null) {
					convertView = LayoutInflater.from(ListActivity.this).inflate(R.layout.list_item, parent, false);

					holder = new ViewHolder();
					convertView.setTag(holder);

				} else {
					holder = (ViewHolder) convertView.getTag();
				}
				return convertView;
			}

			class ViewHolder {

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

package com.captain.wds.myapplication.tempDemo;

import com.captain.wds.myapplication.R;
import com.captain.wds.myapplication.mvp.framework.lce.impl.MvpLceActivity;

public class ListActivity  extends MvpLceActivity<ListModel,ListModelView<ListModel>,ListPresenter>{
    @Override public int getLayoutId() {
        return R.layout.activity_list;
    }

    @Override protected void initData() {

    }

    @Override public ListPresenter createPresenter() {
        return new ListPresenter();
    }

}

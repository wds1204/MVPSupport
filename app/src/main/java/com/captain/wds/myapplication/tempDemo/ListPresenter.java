package com.captain.wds.myapplication.tempDemo;

import com.captain.wds.myapplication.mvp.framework.MvpBasePresenter;
import com.captain.wds.myapplication.mvp.framework.lce.MvpLceView;

public class ListPresenter extends MvpBasePresenter<MvpLceView<PostModel>> {
    private ListModel listModel;
    public ListPresenter() {
        listModel = new ListModel();
    }

    public void getListData(boolean isPullToRefresh) {

        getView().showLoading(isPullToRefresh);
        PostModel postModel = listModel.getListData();

        if (listModel == null ) {
            getView().bindData(null);
        } else {
            getView().bindData(postModel);

        }
//        SystemClock.sleep(10000);

        getView().showContent();


    }

}

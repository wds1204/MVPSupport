package com.captain.wds.myapplication.tempDemo;

import com.captain.wds.myapplication.mvp.MvpModel;

public class ListModel implements MvpModel {

    public PostModel getListData() {

        PostModel postModel = new PostModel();
        return postModel;

    }
}

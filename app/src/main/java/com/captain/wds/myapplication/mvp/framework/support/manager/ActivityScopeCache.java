package com.captain.wds.myapplication.mvp.framework.support.manager;

import android.support.annotation.NonNull;
import android.util.ArrayMap;

import com.captain.wds.myapplication.mvp.MvpPresenter;

import java.util.Map;

public class ActivityScopeCache {

    private final Map<String, PresenterHolder> presenterMap = new ArrayMap<String, PresenterHolder>();

    ActivityScopeCache(){

    }

    //清空缓存
    public void clear(){
        presenterMap.clear();
    }

    //根据指定ID，得到P
    public <P> P getPresenter(String viewId){
        PresenterHolder presenterHolder = presenterMap.get(viewId);
        return presenterHolder == null ? null : (P)presenterHolder.presenter;
    }

    //添加P（缓存P）
    public void putPresenter(String viewId, MvpPresenter<?> presenter){
        if (viewId == null){
            throw new NullPointerException("你的ID为空");
        }
        if (presenter == null){
            throw new NullPointerException("你的presenter不能为空...");
        }
        PresenterHolder holder = presenterMap.get(viewId);
        if (holder == null){
            holder = new PresenterHolder();
            holder.presenter = presenter;
            presenterMap.put(viewId, holder);
        } else {
            holder.presenter = presenter;
        }
    }

    public void remove(String viewId) {
        if (viewId == null){
            throw new NullPointerException("你的ID为空");
        }
        presenterMap.remove(viewId);
    }

    //提供缓存
    public <VS> VS getViewState(@NonNull String viewId){
        PresenterHolder holder = presenterMap.get(viewId);
        return holder == null ? null : (VS)holder.viewState;
    }

    public void putViewState(@NonNull String viewId, @NonNull Object viewState){
        if (viewState == null){
            throw new NullPointerException("viewState不能为空");
        }
        if (viewId == null){
            throw new NullPointerException("viewId不能为空");
        }
        PresenterHolder holder = presenterMap.get(viewId);
        if (holder == null){
            holder = new PresenterHolder();
            holder.viewState = viewState;
            presenterMap.put(viewId, holder);
        } else {
            holder.viewState = viewState;
        }
    }

    static final class PresenterHolder {
        private MvpPresenter<?> presenter;
        private Object viewState;
    }

}

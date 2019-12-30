package com.bw.miaoheng20191230.base.mvp;

import java.lang.ref.WeakReference;

/**
 * 时间 :2019/12/30  8:38
 * 作者 :苗恒
 * 功能 :
 */
public abstract class BasePresenter<M extends IBaseModel,V extends IBaseView>{
    public M model;
    public WeakReference<V> weakReference;

    public BasePresenter() {
        model=initModel();
    }
    public void attach(V v){
         weakReference=new WeakReference<>(v);
    }
    public void deatch(){
        if (weakReference != null) {
            weakReference.clear();
            weakReference=null;
        }
    }

    protected abstract M initModel();
    public V getView(){
        return weakReference.get();
    }
}

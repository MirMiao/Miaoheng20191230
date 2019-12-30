package com.bw.miaoheng20191230.contract;

import com.bw.miaoheng20191230.base.mvp.IBaseModel;
import com.bw.miaoheng20191230.base.mvp.IBaseView;
import com.bw.miaoheng20191230.entity.ShopEntity;

/**
 * 时间 :2019/12/30  8:42
 * 作者 :苗恒
 * 功能 :
 */
public interface IShopContract {
    interface IModel extends IBaseModel {
         void getData(String url,MoldelCallBack moldelCallBack);
         interface MoldelCallBack{
             void success(ShopEntity shopEntity);
             void failur(Throwable throwable);
         }
    }
    interface IView extends IBaseView {
        void success(ShopEntity shopEntity);
        void failur(Throwable throwable);
    }
    interface IPresenter{
        void getData(String url);
    }
}

package com.bw.miaoheng20191230.presenter;

import com.bw.miaoheng20191230.base.mvp.BasePresenter;
import com.bw.miaoheng20191230.contract.IShopContract;
import com.bw.miaoheng20191230.entity.ShopEntity;
import com.bw.miaoheng20191230.model.ShopModel;

/**
 * 时间 :2019/12/30  8:53
 * 作者 :苗恒
 * 功能 :
 */
public class ShopPresenter extends BasePresenter<ShopModel, IShopContract.IView> implements IShopContract.IPresenter {
    @Override
    protected ShopModel initModel() {
        return new ShopModel();
    }

    @Override
    public void getData(String url) {
          model.getData(url, new IShopContract.IModel.MoldelCallBack() {
              @Override
              public void success(ShopEntity shopEntity) {
                  getView().success(shopEntity);
              }

              @Override
              public void failur(Throwable throwable) {
            getView().failur(throwable);
              }
          });
    }
}

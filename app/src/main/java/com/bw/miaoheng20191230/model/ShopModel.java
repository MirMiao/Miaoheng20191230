package com.bw.miaoheng20191230.model;

import com.bw.miaoheng20191230.contract.IShopContract;
import com.bw.miaoheng20191230.entity.ShopEntity;
import com.bw.miaoheng20191230.utils.OkHttpUtils;
import com.google.gson.Gson;

/**
 * 时间 :2019/12/30  8:46
 * 作者 :苗恒
 * 功能 :
 */
public class ShopModel implements IShopContract.IModel {
    @Override
    public void getData(String url, final MoldelCallBack moldelCallBack) {
        OkHttpUtils.getInstance().doGet(url, new OkHttpUtils.OkCallBack() {
            @Override
            public void seccess(String response) {
                ShopEntity shopEntity = new Gson().fromJson(response, ShopEntity.class);
                moldelCallBack.success(shopEntity);
            }

            @Override
            public void failur(Throwable throwable) {
                 moldelCallBack.failur(throwable);
            }
        });
    }
}

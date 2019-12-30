package com.bw.miaoheng20191230;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.miaoheng20191230.base.BaseActivity;
import com.bw.miaoheng20191230.contract.IShopContract;
import com.bw.miaoheng20191230.entity.ShopEntity;
import com.bw.miaoheng20191230.presenter.ShopPresenter;

import java.util.List;

public class MainActivity extends BaseActivity<ShopPresenter> implements IShopContract.IView {


    private TextView textView;

    @Override
    protected ShopPresenter initPresenter() {
        return new ShopPresenter();
    }

    @Override
    protected void initData() {
        presenter.getData("http://172.17.8.100/small/commodity/v1/bannerShow");
    }

    @Override
    protected void initView() {
        textView = findViewById(R.id.tv);
    }

    @Override
    protected int bindLayoutid() {
        return R.layout.activity_main;
    }

    @Override
    public void success(ShopEntity shopEntity) {
        //请求成功的数据
        for (int i = 0; i < shopEntity.getResult().size(); i++) {
             textView.setText(shopEntity.getResult().get(i).getTitle());
            Toast.makeText(this, shopEntity.getResult().get(i).getTitle(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void failur(Throwable throwable) {

    }
}

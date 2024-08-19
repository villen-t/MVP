package com.villen.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.villen.mvp.bean.Banner;
import com.villen.mvp.model.Repository;
import com.villen.mvp.network.ResponseCallback;

import java.util.List;

/**
 * 感谢 wanandroid 提供的开放API.
 * wanandroid 官网
 * https://www.wanandroid.com
 *
 * Controller
 */
public class MainActivity extends AppCompatActivity implements ResponseCallback<List<Banner>> {

    private TextView mBannerInfoTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBannerInfoTv = (TextView) findViewById(R.id.tv_banner_info);
    }

    /**
     * 按钮点击事件
     * @param view
     */
    public void getBannerInfo(View view) {
        getBanners();
    }

    /**
     * 获取 banner 数据
     */
    private void getBanners() {
        Repository.getInstance().getBanners(this);
    }

    @Override
    public void onSuccess(List<Banner> banners) {
        if (banners != null && banners.size() > 0) {
            showBannerInfo(banners);
        }
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT);
    }

    /**
     * 更新UI
     * @param banners
     */
    private void showBannerInfo(List<Banner> banners) {
        StringBuilder sb = new StringBuilder("wanandroid 官网\nhttps://www.wanandroid.com\n\n");
        for(Banner item : banners) {
            sb.append(item.getTitle()).append('\n');
        }

        mBannerInfoTv.setText(sb.toString());
    }
}
package com.villen.mvp.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.villen.mvp.contract.main.IMainPresenter;
import com.villen.mvp.contract.main.IMainView;
import com.villen.mvp.R;
import com.villen.mvp.base.BaseActivity;
import com.villen.mvp.bean.Banner;

import java.util.List;

/**
 * 感谢 wanandroid 提供的开放API.
 * wanandroid 官网
 * https://www.wanandroid.com
 * <p>
 * View
 */
public class MainActivity extends BaseActivity<IMainPresenter> implements IMainView {

    private TextView mBannerInfoTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBannerInfoTv = (TextView) findViewById(R.id.tv_banner_info);
    }

    @Override
    public IMainPresenter createPresenter() {
        return new MainPresenter();
    }

    /**
     * 按钮点击事件
     *
     * @param view
     */
    public void getNetworkInfo(View view) {
        // 收到点击事件，交给 presenter 进行业务处理
        if (mPresenter != null) {
            mPresenter.getNetworkBanner();
        }
    }

    /**
     * 按钮点击事件
     *
     * @param view
     */
    public void getLocalInfo(View view) {
        // 收到点击事件，交给 presenter 进行业务处理
        if (mPresenter != null) {
            mPresenter.getLocalBanner();
        }
    }

    /**
     * 按钮点击事件
     *
     * @param view
     */
    public void clearLocalInfo(View view) {
        // 收到点击事件，交给 presenter 进行业务处理
        if (mPresenter != null) {
            mPresenter.clearLocalData();
        }
    }

    @Override
    public void updateBanner(List<Banner> banners, String from) {
        // 收到更新 ui 事件，更新 ui
        showBannerInfo(banners, from);
    }

    /**
     * 更新UI
     *
     * @param banners
     */
    private void showBannerInfo(List<Banner> banners, String from) {
        StringBuilder sb = new StringBuilder();

        if (banners.size() > 0) {
            sb.append("wanandroid 官网\nhttps://www.wanandroid.com\n\n")
                    .append("data from ").append(from).append(":\n");
            for (Banner item : banners) {
                Log.e("banner", item.toString());
                sb.append(item.getTitle()).append('\n');
            }
        }

        mBannerInfoTv.setText(sb.toString());
    }
}
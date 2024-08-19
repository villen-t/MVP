package com.villen.mvp.contract.main;

import com.villen.mvp.contract.base.IPresenter;
import com.villen.mvp.contract.base.IView;
import com.villen.mvp.bean.Banner;

import java.util.List;

public interface IMainPresenter<V extends IView> extends IPresenter<V> {
    /**
     * 获取 banner 网络数据
     */
    void getNetworkBanner();

    /**
     * 获取 banner 本地数据
     */
    void getLocalBanner();

    /**
     * 存储 banner 数据
     *
     * @param banners
     */
    void saveBanner(List<Banner> banners);

    /**
     * 清空本地数据
     */
    void clearLocalData();
}

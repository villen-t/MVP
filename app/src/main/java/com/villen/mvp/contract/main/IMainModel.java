package com.villen.mvp.contract.main;

import com.villen.mvp.contract.base.IModel;
import com.villen.mvp.bean.Banner;
import com.villen.mvp.network.ResponseCallback;

import java.util.List;

public interface IMainModel extends IModel {
    /**
     * 请求 banner 数据
     *
     * @param callback
     */
    void getNetworkBanner(ResponseCallback<List<Banner>> callback);

    /**
     * 读取 banner 本地数据
     *
     * @return
     */
    List<Banner> getLocalBanner();

    /**
     * 持久化存储 banner 数据
     *
     * @param banners
     */
    void saveBanner(List<Banner> banners);

    /**
     * 清空本地数据
     */
    void clearLocalData();
}

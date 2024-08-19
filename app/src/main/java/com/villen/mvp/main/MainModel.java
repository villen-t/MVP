package com.villen.mvp.main;

import com.villen.mvp.contract.main.IMainModel;
import com.villen.mvp.base.BaseModel;
import com.villen.mvp.bean.Banner;
import com.villen.mvp.model.CacheRepository;
import com.villen.mvp.model.NetworkRepository;
import com.villen.mvp.network.ResponseCallback;

import java.util.List;

/**
 * Model
 */
public class MainModel extends BaseModel implements IMainModel {
    @Override
    public void getNetworkBanner(ResponseCallback<List<Banner>> callback) {
        // 收到需求，请求接口数据
        NetworkRepository.getInstance().requestBanners(callback);
    }

    @Override
    public List<Banner> getLocalBanner() {
        // 收到需求，读取本地数据
        return CacheRepository.getInstance().getBanners();
    }

    @Override
    public void saveBanner(List<Banner> banners) {
        // 收到需求，持久化存储 banner 数据
        CacheRepository.getInstance().saveBanners(banners);
    }

    @Override
    public void clearLocalData() {
        // 收到需求，清空本地缓存数据
        CacheRepository.getInstance().clearLocalData();
    }
}

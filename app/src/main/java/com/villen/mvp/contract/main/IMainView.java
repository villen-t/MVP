package com.villen.mvp.contract.main;

import com.villen.mvp.contract.base.IView;
import com.villen.mvp.bean.Banner;

import java.util.List;

public interface IMainView extends IView {
    /**
     * 更新 banner 数据
     *
     * @param banners
     */
    void updateBanner(List<Banner> banners, String from);
}

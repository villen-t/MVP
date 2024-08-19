package com.villen.mvp.main;

import com.villen.mvp.contract.main.IMainModel;
import com.villen.mvp.contract.main.IMainPresenter;
import com.villen.mvp.contract.main.IMainView;
import com.villen.mvp.base.BasePresenter;
import com.villen.mvp.bean.Banner;
import com.villen.mvp.constant.CommonConstant;
import com.villen.mvp.network.ResponseCallback;

import java.util.List;

/**
 * Presenter
 */
public class MainPresenter extends BasePresenter<IMainView, IMainModel>
        implements IMainPresenter<IMainView> {

    @Override
    protected IMainModel createModel() {
        return new MainModel();
    }

    @Override
    public void getNetworkBanner() {
        if (mModel == null) {
            return;
        }
        // 收到新需求，分发给 model 处理
        mModel.getNetworkBanner(new ResponseCallback<List<Banner>>() {
            @Override
            public void onSuccess(List<Banner> banners) {
                // 数据缓存
                saveBanner(banners);

                // 通知更新UI
                notifyUpdateBanner(banners, CommonConstant.FROM_NETWORK);
            }

            @Override
            public void onFail(String msg) {
                IMainView view = mView.get();
                if (view != null) {
                    view.showErr(msg);
                }
            }
        });
    }

    @Override
    public void getLocalBanner() {
        if (mModel == null) {
            return;
        }
        // 收到新需求，分发给 model 处理
        List<Banner> banners = mModel.getLocalBanner();

        // 通知更新UI
        notifyUpdateBanner(banners, CommonConstant.FROM_LOCAL);
    }

    @Override
    public void saveBanner(List<Banner> banners) {
        // 收到新需求，分发给 model 处理
        if (mModel != null) {
            mModel.saveBanner(banners);
        }
    }

    @Override
    public void clearLocalData() {
        // 收到新需求，分发给 model 处理
        if (mModel != null) {
            mModel.clearLocalData();
        }
    }

    /**
     * 通知更新UI
     *
     * @param banners
     */
    private void notifyUpdateBanner(List<Banner> banners, String from) {
        // 获取到数据，通知更新 ui
        if (mView != null) {
            IMainView view = mView.get();
            if (view != null) {
                view.updateBanner(banners, from);
            }
        }
    }
}

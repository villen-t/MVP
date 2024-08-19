package com.villen.mvp.contract.base;

public interface IPresenter<V extends IView> {
    void attachView(V view);
    void detachView();
    void onDestroy();
}

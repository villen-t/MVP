package com.villen.mvp.base;

import com.villen.mvp.contract.base.IModel;
import com.villen.mvp.contract.base.IPresenter;
import com.villen.mvp.contract.base.IView;

import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IView, M extends IModel> implements IPresenter<V> {

    protected WeakReference<V> mView;
    protected M mModel;

    public BasePresenter() {
        this.mModel = createModel();
    }

    protected abstract M createModel();

    @Override
    public void attachView(V view) {
        mView = new WeakReference<>(view);
    }

    @Override
    public void detachView() {
        if (mView.get() != null) {
            mView.clear();
        }
    }

    @Override
    public void onDestroy() {
        if (mModel != null) {
            mModel = null;
        }
    }
}

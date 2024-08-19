package com.villen.mvp.base;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.villen.mvp.contract.base.IPresenter;
import com.villen.mvp.contract.base.IView;

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity
        implements IView {

    protected P mPresenter;

    public BaseActivity() {
        this.mPresenter = createPresenter();
        mPresenter.attachView(this);
    }

    public abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Activity 销毁时，需要调用 detachView，防止内存泄漏
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }

    @Override
    public void showErr(String errMsg) {
        Toast.makeText(this, errMsg, Toast.LENGTH_SHORT);
    }
}

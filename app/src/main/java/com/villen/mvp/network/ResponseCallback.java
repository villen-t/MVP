package com.villen.mvp.network;

/**
 * 响应回调
 * @param <T>
 */
public interface ResponseCallback<T> {
    void onSuccess(T t);
    void onFail(String msg);
}

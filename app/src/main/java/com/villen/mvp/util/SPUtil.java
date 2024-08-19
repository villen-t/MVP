package com.villen.mvp.util;

import android.content.Context;

import com.villen.mvp.constant.CommonConstant;

public final class SPUtil {

    private static Context sContext;

    private SPUtil() {

    }

    public static void init(Context context) {
        sContext = context;
    }

    public static void putString(String key, String value) {
        sContext.getSharedPreferences(CommonConstant.SP_NAME, Context.MODE_PRIVATE)
                .edit()
                .putString(key, value)
                .commit();
    }

    public static String getString(String key) {
        return sContext.getSharedPreferences(CommonConstant.SP_NAME, Context.MODE_PRIVATE)
                .getString(key, CommonConstant.DEFAULT_VALUE);
    }

    public static void clearAll() {
        sContext.getSharedPreferences(CommonConstant.SP_NAME, Context.MODE_PRIVATE)
                .edit()
                .clear()
                .apply();
    }
}

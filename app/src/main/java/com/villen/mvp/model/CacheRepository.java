package com.villen.mvp.model;

import com.villen.mvp.bean.Banner;
import com.villen.mvp.util.SPUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Cache Repository
 */
public class CacheRepository {

    private CacheRepository() {

    }

    public static CacheRepository getInstance() {
        return SingletonHolder.sInstance;
    }

    private static final class SingletonHolder {
        private static final CacheRepository sInstance = new CacheRepository();
    }

    /**
     * 获取 banner 本地数据
     *
     * @return
     */
    public List<Banner> getBanners() {
        List<Banner> banners = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            try {
                JSONObject json = new JSONObject(SPUtil.getString(String.valueOf(i)));
                String title = json.getString("title");
                Banner banner = new Banner();
                banner.setTitle(title);
                banners.add(banner);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return banners;
    }

    /**
     * 缓存 banner 数据
     *
     * @param banner
     */
    public void saveBanners(List<Banner> banner) {
        for (int i = 0; i < banner.size(); i++) {
            try {
                JSONObject json = new JSONObject();
                json.put("title", banner.get(i).getTitle());
                SPUtil.putString(String.valueOf(i), json.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 清空本地缓存数据
     */
    public void clearLocalData() {
        SPUtil.clearAll();
    }
}

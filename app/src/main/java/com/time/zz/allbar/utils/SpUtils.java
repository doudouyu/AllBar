package com.time.zz.allbar.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by admin on 2016/8/4.
 */
public class SpUtils {

    /**
     * 保存Int
     *
     * @param key
     * @param value
     */
    public static void saveInt(String key, int value) {
        SharedPreferences sp = MyApplication.getInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).commit();
    }

    /**
     * 获取int
     *
     * @param key
     * @return
     */
    public static int getInt( String key) {
        SharedPreferences sp = MyApplication.getInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getInt(key, 0);
    }

    /**
     * 保存string
     * @param key
     * @param value
     */
    public static void saveString(String key, String value) {
        SharedPreferences sp = MyApplication.getInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }
    /**
     * 获取string
     *
     * @param key
     * @return
     */

    public static String getString(String key) {
        SharedPreferences sp = MyApplication.getInstance().getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getString(key,"");
    }
}

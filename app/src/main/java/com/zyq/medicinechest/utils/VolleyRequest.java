package com.zyq.medicinechest.utils;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.zyq.medicinechest.app.App;

import java.util.Map;

/**
 * Created by ZYQ on 2016/4/19.
 * 对Volley进行二次封装
 * 用于各种各样的网络请求
 */
public class VolleyRequest {

    private static VolleyRequest mInstance;
    public static StringRequest stringRequest;
    public static Context context;

    /**
     * 网络请求单例化
     */
    private static VolleyRequest getInstance() {
        if (mInstance == null) {
            synchronized (VolleyRequest.class) {
                if (mInstance == null) {
                    mInstance = new VolleyRequest();
                }
            }
        }
        return mInstance;
    }

    /**
     * get请求
     * 数据的处理在调用这个方法的地方实行
     *
     * @param url
     * @param vif 抽象类，具体实现方法在VolleyInterface处
     */
    private void requestGetIn(Context context, String url, String tag,
                                  VolleyInterface vif) {

        // 防止进行重复请求
        App.getHttpQueues().cancelAll(tag);

        stringRequest = new StringRequest(Request.Method.GET, url,
                vif.loadingListener(), vif.errorListener());
        stringRequest.setTag(tag);
        App.getHttpQueues().add(stringRequest);
        App.getHttpQueues().start();
    }

    public static void requestGet(Context context, String url, String tag,
                                   VolleyInterface vif) {
        getInstance().requestGetIn(context, url, tag, vif);
    }

    /**
     * post请求
     * 数据的处理在调用这个方法的地方实行
     *
     * @param url
     * @param vif 抽象类，具体实现方法在VolleyInterface处
     */
    private void requestPostIn(Context context, String url, String tag,
                                   final Map<String, String> params, VolleyInterface vif) {
        App.getHttpQueues().cancelAll(tag);
        stringRequest = new StringRequest(url, vif.loadingListener(), vif.errorListener()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        stringRequest.setTag(tag);
        App.getHttpQueues().add(stringRequest);
        App.getHttpQueues().start();
    }

    public static void requestPost(Context context, String url, String tag,
                                    final Map<String, String> params, VolleyInterface vif) {
        getInstance().requestPostIn(context, url, tag, params, vif);
    }
}

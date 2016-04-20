package com.zyq.medicinechest.utils;

import android.content.Context;

import com.android.volley.Response.Listener;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;

/**
 * Created by ZYQ on 2016/4/19.
 * 请求成功与失败的接口回调
 */
public abstract class VolleyInterface {

    public Context context;
    public static Listener listener;
    public static ErrorListener errorListener;

    public VolleyInterface(Context context, Listener<String> listener,
                           ErrorListener errorListener) {
        this.context = context;
        this.listener = listener;
        this.errorListener = errorListener;
    }

    // 定义两个抽象方法，用于网络请求的回调
    public abstract void onSuccess(String result);
    public abstract void onError(VolleyError error);

    public Listener<String> loadingListener() {
        listener = new Listener<String>() {
            @Override
            public void onResponse(String result) {
                onSuccess(result);
                // 可写请求成功的提示
            }
        };
        return listener;
    }

    public ErrorListener errorListener() {
        errorListener = new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                onError(volleyError);
                // 可写请求失败的提示
            }
        };
        return errorListener;
    }
}

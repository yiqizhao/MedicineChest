package com.zyq.medicinechest.app;

import android.app.Activity;
import android.app.Application;
import android.util.DisplayMetrics;


import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZYQ on 2016/3/14.
 */
public class App extends Application {

    private static List<Activity> mList = new ArrayList<>();
    private static App instance;
    private static DisplayMetrics metrics;
    private static Boolean NetState = true;
    private static String URL;
    public static RequestQueue queues;

    @Override
    public void onCreate() {
        super.onCreate();
        queues = Volley.newRequestQueue(getApplicationContext());
    }

    /**
     * 返回网络请求队列
     *
     * @return
     */
    public static RequestQueue getHttpQueues() {
        return queues;
    }

    public static void addActivity(Activity activity) {
        mList.add(activity);
    }

    /**
     * 获取网络连接状态
     *
     * @return
     */
    public static Boolean getNetState() {
        return NetState;
    }

    public static String getUrl(){
        return URL;
    }

    /**
     * 获取屏幕参数
     *
     * @return
     */
    public static DisplayMetrics getMetrics() {
        return metrics;
    }

    /**
     * 设置屏幕参数
     *
     * @param metrics
     */
    public static void setMetrics(DisplayMetrics metrics) {
        App.metrics = metrics;
    }

    //退出程序
    public static void exit() {
        try {
            for (Activity activity : mList) {
                if (activity != null)
                    activity.finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
}

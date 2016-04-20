package com.zyq.medicinechest.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;

import com.zyq.medicinechest.R;
import com.zyq.medicinechest.app.App;
import com.zyq.medicinechest.base.BaseActivity;

/**
 * Created by ZYQ on 2016/3/14.
 */
public class SplashActivity extends BaseActivity {

    private Context context;
    Handler handler = new Handler();

    @Override
    public int getLayoutId() {
        return R.layout.activity_first;
    }

    @Override
    public void initViews() {

        context = this;

        // 获得屏幕宽高
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        App.setMetrics(metric);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                intent.putExtra("success", true);
                startActivity(intent);
                finish();
            }
        }, 2000);

    }

    @Override
    public void setupViews(Bundle bundle) {

    }

}

package com.zyq.medicinechest.base;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.zyq.medicinechest.app.App;

/**
 * Created by ZYQ on 2016/3/14.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected static String TAG;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        TAG = this.getClass().getSimpleName();
        App.addActivity(this);
        // 由于应用没有做横屏的优化，所以这里固定显示为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initViews();
        setupViews(savedInstanceState);
    }

    public abstract int getLayoutId();

    public abstract void initViews();

    public abstract void setupViews(Bundle bundle);
    public void showToast(String info) {
        Toast.makeText(BaseActivity.this, info, Toast.LENGTH_SHORT).show();
    }

}

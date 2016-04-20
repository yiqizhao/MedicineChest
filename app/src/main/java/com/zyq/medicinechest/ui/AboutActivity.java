package com.zyq.medicinechest.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zyq.medicinechest.R;
import com.zyq.medicinechest.other_view.CusDialog;

/**
 * Created by acer-PC on 2015/11/9.
 * 侧拉栏的 关于
 */
public class AboutActivity extends NormalActivity implements View.OnClickListener {

    private Button btnUpdate, btnshare, btnAdavice;
    private Context context;

    @Override
    public int getLayoutId() {
        return R.layout.activity_about;
    }

    @Override
    public void initViews() {

        context = AboutActivity.this;

        btnUpdate = (Button) findViewById(R.id.activity_about_bn_updata);
        btnshare = (Button) findViewById(R.id.activity_about_delete);
        btnAdavice = (Button) findViewById(R.id.activity_about_sug);
    }

    @Override
    public void setupViews(Bundle bundle) {
        btnAdavice.setOnClickListener(this);
        btnshare.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //升级
            case R.id.activity_about_bn_updata:
                showToast("当前已是最新版本");
                break;

            //分享应用
            case R.id.activity_about_delete:
                final AlertDialog dialog = CusDialog.showProgressDialog(context,
                        "正在清理");

                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                        showToast("清理成功");
                    }
                };
                Handler handler = new Handler();
                handler.postDelayed(runnable, 1000);
                break;

            //用户反馈
            case R.id.activity_about_sug:
                showToast("该功能暂未实现");
                break;
        }
    }

    @Override
    public void setTitleBarText(TextView textView) {
        textView.setText("关于");
    }
}

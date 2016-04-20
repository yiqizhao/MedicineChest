package com.zyq.medicinechest.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.zyq.medicinechest.R;
import com.zyq.medicinechest.base.BaseActivity;

/**
 * Created by ZYQ on 2016/3/14.
 */
public abstract class NormalActivity extends BaseActivity {

    ImageButton imageButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = (TextView) findViewById(R.id.tv_normal_titlebar_title);
        imageButton = (ImageButton) findViewById(R.id.button_normal_titlebar_left);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setTitleBarText(textView);
    }

    //设置toolbar的文字
    public abstract void setTitleBarText(TextView textView);

}


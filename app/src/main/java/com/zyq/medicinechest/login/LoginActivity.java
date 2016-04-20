package com.zyq.medicinechest.login;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.zyq.medicinechest.R;
import com.zyq.medicinechest.base.BaseActivity;

/**
 * Created by ZYQ on 2016/3/22.
 */
public class LoginActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void setupViews(Bundle bundle) {

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.activity_contentview_login, new LoginFragment()).commit();


    }

}

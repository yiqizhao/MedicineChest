package com.zyq.medicinechest.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zyq.medicinechest.R;
import com.zyq.medicinechest.base.BaseFragment;
import com.zyq.medicinechest.other_view.TitleBar;

/**
 * Created by ZYQ on 2016/3/22.
 */
public class LoginFragment extends BaseFragment {

    private TitleBar title;
    private TextView findPassword;
    private EditText userName;
    private EditText password;
    private Button loginBtn;
    private boolean ordering ;
    private int loginSuccess;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initViews(View view) {

        ordering = getActivity().getIntent().getBooleanExtra("ordering", false);
        findPassword = (TextView) view.findViewById(R.id.tv_find_pass_fragment_login);
        loginBtn = (Button) view.findViewById(R.id.btn_fragment_login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });


        title = (TitleBar) view.findViewById(R.id.titlebar_fragment_login);
        title.setTitleText("登录");
        title.setLeftText("返回");

        title.setLeftButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });

        userName = (EditText) view.findViewById(R.id.username_fragment_login);
        password = (EditText) view.findViewById(R.id.password_fragment_login);



    }

    @Override
    protected void setupViews(Bundle bundle) {

    }

    private void login() {
        // TODO
        loginSuccess = 0;
        final String username_str = userName.getText().toString();
        if (username_str == "admin") {
            showToast("登录成功");
        }
    }

    private void doLogin (String username_str, String password_str) {
        // TODO
    }
}

package com.zyq.medicinechest.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.zyq.medicinechest.R;
import com.zyq.medicinechest.base.BaseFragment;
import com.zyq.medicinechest.utils.VolleyInterface;
import com.zyq.medicinechest.utils.VolleyRequest;

/**
 * Created by ZYQ on 2016/3/17.
 */
public class RemindFragment extends BaseFragment {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_remind;
    }

    @Override
    protected void initViews(View view) {

    }

    @Override
    protected void setupViews(Bundle bundle) {
        volleyGet();
    }

    private void volleyGet() {
        String url = "http://120.24.174.205/iMedical/android_user_login.action";
        VolleyRequest.requestGet(getActivity(), url, "abcGet", new VolleyInterface(getActivity(),
                VolleyInterface.listener, VolleyInterface.errorListener) {
            @Override
            public void onSuccess(String result) {
                Toast.makeText(getActivity(), result, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(VolleyError error) {
                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}

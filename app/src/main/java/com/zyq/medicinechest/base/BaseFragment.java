package com.zyq.medicinechest.base;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by ZYQ on 2016/3/14.
 */
public abstract class BaseFragment extends Fragment {

    public String TAG;
    private View mContentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mContentView == null) {
            mContentView = inflater.inflate(getLayoutId(), container, false);
            initViews(mContentView);
            setupViews(savedInstanceState);

            // 缓存的mContentView需要判断是否已经被加过parent，
            // 如果有parent需要从parent删除，要不然会发生这个mContentView已经有parent的错误。
            ViewGroup parent = (ViewGroup) mContentView.getParent();
            if (parent != null) {
                parent.removeView(mContentView);
            }
        }
        TAG = this.getClass().getSimpleName();
        return mContentView;
    }

    public abstract int getLayoutId();

    protected abstract void initViews(View view);

    protected abstract void setupViews(Bundle bundle);

    public void showToast(String info) {

        if (getActivity() != null)
            Toast.makeText(getActivity(), info, Toast.LENGTH_SHORT).show();
    }

}

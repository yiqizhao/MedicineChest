package com.zyq.medicinechest.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.zyq.medicinechest.R;
import com.zyq.medicinechest.app.App;
import com.zyq.medicinechest.base.BaseActivity;
import com.zyq.medicinechest.fragment.MChestFragment;
import com.zyq.medicinechest.fragment.RemindFragment;
import com.zyq.medicinechest.fragment.CareFragment;
import com.zyq.medicinechest.login.LoginActivity;
import com.zyq.medicinechest.other_view.DialogTool;
import com.zyq.medicinechest.utils.FragmentUtil;


public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    //侧拉栏的各项
    private static final int REMIND = 0;
    private static final int CARE = 1;
    private static final int MCHEST = 2;
    private int mCurrentIndex = 0;
    private TextView mTitle;
    private Button bnUser;
    private LayoutInflater minflater;
    private FrameLayout mFrameLayout;
    private View mainView;
    private Boolean mDrawerOpenFlag = false;
    private DrawerLayout drawer;
    private MenuItem menuItem;
    private int mIndex;
    private Context context = this;

    private RemindFragment remindFragment;
    private CareFragment careFragment;
    private MChestFragment mChestFragment;
    private Fragment nowFragment;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        mTitle = (TextView) findViewById(R.id.text_toolbar);

        mFrameLayout = (FrameLayout) findViewById(R.id.center_view_main_activity);
        minflater = LayoutInflater.from(context);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        mTitle.setText("智能药箱");
        setSupportActionBar(toolbar);

        // 设置隐藏Toolbar原来的Title
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // 设置图标是否显示
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // 设置是否将图标转变为可点击的按钮
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bnUser = (Button) findViewById(R.id.drawer_bn_user);

        bnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogTool.createConfirmDialog(context, "提示", "您还未登录，现在去登录？", "确定",
                        "取消", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                dialog.dismiss();
                                startActivity(new Intent(context, LoginActivity.class));
                            }
                        }, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                dialog.dismiss();
                            }
                        }).show();
            }
        });

    }

    @Override
    public void setupViews(Bundle bundle) {


        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (remindFragment == null) {
            remindFragment = new RemindFragment();
        }
        nowFragment = remindFragment;
        transaction.replace(R.id.center_view_main_activity, remindFragment).commit();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            startActivity(intent);
        }
        else if (id == R.id.action_about) {
            Intent intent = new Intent(context, AboutActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
        }
        else if (id == R.id.action_exit) {
            App.exit();
        }

        return super.onOptionsItemSelected(item);
    }



    /**
     * 重写点击按键时的回调方法
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 监听返回键
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else if (mCurrentIndex == 0) {
                // 调用一个退出程序的dialog
                DialogTool.createConfirmDialog(context, "提示", "确定要退出应用？", "确定",
                        "取消", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                App.exit();// 点击确定按钮退出应用
                            }
                        }, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                dialog.dismiss();
                            }
                        }).show();
                return true;
            }
        }

        // 监听菜单键
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            if (mDrawerOpenFlag == true) {
                // 关闭侧滑菜单
                drawer.closeDrawer(GravityCompat.START);
                mDrawerOpenFlag = false;
            } else {
                // 开启侧滑菜单
                drawer.openDrawer(GravityCompat.START);
                mDrawerOpenFlag = true;
            }
        }
        return true;

    }

    private void changeFragment(int index,Fragment fromFragment, Fragment toFragment) {

        if (nowFragment != toFragment) {
            nowFragment = toFragment;
        }

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        mTitle.setText(FragmentUtil.stringTitle.get(index));

        if (toFragment.isAdded() == false) {
            ft.hide(fromFragment).add(R.id.center_view_main_activity, toFragment).commit();
        } else {
            ft.hide(fromFragment).show(toFragment).commit();
        }

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction  = fragmentManager.beginTransaction();

        int id = item.getItemId();

        if (id == R.id.nav_remind) {

            if (remindFragment == null) {
                remindFragment = new RemindFragment();
            }
            changeFragment(0, nowFragment, remindFragment);

        } else if (id == R.id.nav_care) {

            if (careFragment == null) {
                careFragment = new CareFragment();
            }
            changeFragment(1, nowFragment, careFragment);

        } else if (id == R.id.nav_mchest) {

            if (mChestFragment == null) {
                mChestFragment = new MChestFragment();
            }
            changeFragment(2, nowFragment, mChestFragment);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

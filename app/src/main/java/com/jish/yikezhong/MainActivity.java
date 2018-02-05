package com.jish.yikezhong;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatDelegate;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;
import com.jish.yikezhong.activity.LogActivity;
import com.jish.yikezhong.activity.LoginActivity;
import com.jish.yikezhong.adapter.MyAdapter;
import com.jish.yikezhong.fragment.Fragment_duanzi;
import com.jish.yikezhong.fragment.Fragment_shipin;
import com.jish.yikezhong.fragment.Fragment_tuijian;
import com.jish.yikezhong.retrofit.MainAlication;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.view_pager)
    ViewPager pager;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.tan)
    SimpleDraweeView tan;
    @BindView(R.id.guanzhu)
    RelativeLayout guanzhu;
    @BindView(R.id.shoucang)
    RelativeLayout shoucang;
    @BindView(R.id.sousuo)
    RelativeLayout sousuo;
    @BindView(R.id.tongzhi)
    RelativeLayout tongzhi;
    @BindView(R.id.yejian)
    RelativeLayout yejian;
    @BindView(R.id.drawer_gen)
    DrawerLayout drawerGen;
    @BindView(R.id.linear_drawer)
    RelativeLayout linearDrawer;
    @BindView(R.id.night)
    TextView night;
    @BindView(R.id.titlelayout)
    LinearLayout titlelayout;
    @BindView(R.id.circleImageView)
    SimpleDraweeView circleImageView;
    @BindView(R.id.name)
    TextView name;
    private ArrayList<Fragment> list;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        night.setTag(1);//夜间模式
//       BottomTabBar mBottomTabBar = findViewById(R.id.bottom_tab_bar);
//        mBottomTabBar.init(getSupportFragmentManager())
//                .setImgSize(50,50)
//                .setFontSize(12)
//                .setTabPadding(4,6,10)
//                .setChangeColor(Color.BLUE,Color.GRAY)
//                .addTabItem("推荐", R.drawable.home_tuijian, Fragment_tuijian.class)
//                .addTabItem("段子", R.drawable.home_duanzi, Fragment_duanzi.class)
//                .addTabItem("视频", R.drawable.home_shipin, Fragment_shipin.class)
//                .setTabBarBackgroundColor(Color.WHITE)
//                .isShowDivider(false);

        list = new ArrayList<>();
        list.add(new Fragment_tuijian());
        list.add(new Fragment_duanzi());
        list.add(new Fragment_shipin());
        MyAdapter adapter = new MyAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                radioGroup.check(radioGroup.getChildAt(position).getId());
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.tuijian:
                        pager.setCurrentItem(0, false);
                        break;
                    case R.id.duanzi:
                        pager.setCurrentItem(1, false);
                        break;
                    case R.id.shipin:
                        pager.setCurrentItem(2, false);
                        break;
                }
            }
        });
        pager.setOffscreenPageLimit(3);
    }

    @OnClick({R.id.tan, R.id.guanzhu, R.id.shoucang, R.id.sousuo, R.id.tongzhi, R.id.night,R.id.circleImageView, R.id.name})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tan:
                //点击图片 侧滑菜单出现
                if (!drawerGen.isDrawerOpen(linearDrawer)) {
                    //如果当前已经关闭了侧面,就打开
                    drawerGen.openDrawer(linearDrawer);
                }
                break;
            case R.id.guanzhu:
                break;
            case R.id.shoucang:
                break;
            case R.id.sousuo:
                break;
            case R.id.tongzhi:
                break;
            case R.id.night:
                int mode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                if (mode == Configuration.UI_MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    night.setText("夜间模式");
                    titlelayout.setBackgroundColor(Color.RED);
                    // bottomRelative.setBackgroundColor(Color.WHITE);
                } else if (mode == Configuration.UI_MODE_NIGHT_NO) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    titlelayout.setBackgroundColor(Color.BLACK);
                    // bottomRelative.setBackgroundColor(Color.BLACK);
                    night.setText("日间模式");
                } else {
                    // blah blah
                }

                recreate();
                int tag = (int) night.getTag();
                if (tag == 1) {
                    night.setTag(2);
                    night.setText("日间模式");
                } else {
                    night.setTag(1);
                    night.setText("夜间模式");
                }
                drawerGen.closeDrawer(linearDrawer);

                break;
            case R.id.circleImageView:
                Intent intent = new Intent(MainActivity.this, LogActivity.class);
                startActivity(intent);
                break;
            case R.id.name:
                Intent intent1 = new Intent(MainActivity.this, LogActivity.class);
                startActivity(intent1);
                break;
        }
    }

    //点俩次退出
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 5000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }

    }
}

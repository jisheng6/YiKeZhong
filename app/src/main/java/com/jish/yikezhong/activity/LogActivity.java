package com.jish.yikezhong.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jish.yikezhong.MainActivity;
import com.jish.yikezhong.R;
import com.jish.yikezhong.retrofit.MainAlication;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Adminjs on 2018/1/25.
 */

public class LogActivity extends Activity {
    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.weixin)
    ImageView weixin;
    @BindView(R.id.qq)
    ImageView qq;
    @BindView(R.id.qita)
    TextView qita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.fan, R.id.weixin, R.id.qq, R.id.qita})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fan:
                Intent intent = new Intent(LogActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.weixin:
                break;
            case R.id.qq:
                break;
            case R.id.qita:
                Intent intent2 = new Intent(LogActivity.this, LoginActivity.class);
                startActivity(intent2);
                break;
        }
    }
}

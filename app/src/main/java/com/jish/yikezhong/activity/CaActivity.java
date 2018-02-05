package com.jish.yikezhong.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.jish.yikezhong.MainActivity;
import com.jish.yikezhong.R;

/**
 * Created by Adminjs on 2018/1/25.
 */

public class CaActivity extends Activity{
        private int time = 3;
        private Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if (time>0){
                    time--;
                    handler.sendEmptyMessageDelayed(0,1000);
                }else{
                    Intent intent = new Intent(CaActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ca);
        handler.sendEmptyMessageDelayed(0,1000);
    }
}

package com.jish.yikezhong.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jish.yikezhong.MainActivity;
import com.jish.yikezhong.R;
import com.jish.yikezhong.bean.ZhuCeBean;
import com.jish.yikezhong.retrofit.MainAlication;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adminjs on 2018/1/25.
 */

public class ZhuceActivity extends Activity {
    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.usname)
    EditText usname;
    @BindView(R.id.uspass)
    EditText uspass;
    @BindView(R.id.login_zhu)
    ImageView loginZhu;
    @BindView(R.id.youlogin_zhu)
    TextView youloginZhu;
    @BindView(R.id.yiyou)
    TextView yiyou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.fanhui, R.id.login_zhu, R.id.youlogin_zhu,R.id.yiyou})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.yiyou:
                Intent intent1 = new Intent(ZhuceActivity.this, LoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.fanhui:
                Intent intent = new Intent(ZhuceActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.login_zhu:
                String p = usname.getText().toString().trim();
                String pa = uspass.getText().toString().trim();
                MainAlication.api.getZhuCe(p, pa)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<ZhuCeBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(ZhuCeBean zhuCeBean) {
                                String code = zhuCeBean.getCode();
                                if (code.equals("0")) {
                                    Toast.makeText(ZhuceActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                                    finish();
                                } else {
                                    Toast.makeText(ZhuceActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
                break;
            case R.id.youlogin_zhu:
                Intent intent2 = new Intent(ZhuceActivity.this,MainActivity.class);
                startActivity(intent2);
                break;
        }
    }
}

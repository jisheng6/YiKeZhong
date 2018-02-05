package com.jish.yikezhong.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jish.yikezhong.MainActivity;
import com.jish.yikezhong.R;
import com.jish.yikezhong.bean.LoginBean;
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

public class LoginActivity extends Activity {
    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.userpass)
    EditText userpass;
    @BindView(R.id.login)
    ImageView login;
    @BindView(R.id.pas_wnag)
    TextView pas_wnag;
    @BindView(R.id.log_you)
    TextView lo_you;
    @BindView(R.id.zhu_hao)
    TextView zhuHao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.fanhui, R.id.login, R.id.pas_wnag, R.id.log_you,R.id.zhu_hao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zhu_hao:
                Intent intent2 = new Intent(LoginActivity.this, ZhuceActivity.class);
                startActivity(intent2);
                break;
            case R.id.pas_wnag:

                break;
            case R.id.log_you:
                Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.fanhui:
                Intent intent = new Intent(LoginActivity.this, LogActivity.class);
                startActivity(intent);
                break;
            case R.id.login:
                String p = username.getText().toString().trim();
                String pa = userpass.getText().toString().trim();
                MainAlication.api.getLogin(p, pa)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<LoginBean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(LoginBean loginBean) {
                                String code = loginBean.getCode();
                                if (code.equals("0")) {
                                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    int uid = loginBean.getData().getUid();
                                    String mobile = loginBean.getData().getMobile();
                                    String token = loginBean.getData().getToken();
                                    SharedPreferences sp = getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor edit = sp.edit();
                                    edit.putString("name", mobile);
                                    edit.putString("token",token);
                                    edit.putInt("uid", uid);
                                    edit.commit();
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
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

        }
    }
}

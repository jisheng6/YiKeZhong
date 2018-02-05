package com.jish.yikezhong.model;

import com.jish.yikezhong.bean.FuJinBean;
import com.jish.yikezhong.bean.ReMenBean;
import com.jish.yikezhong.retrofit.MainAlication;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adminjs on 2018/1/26.
 */

public class FuJinModel {
    public void getData(String page,String token,final ModelCallBack callBack){
        MainAlication.api.getFuJin(page,token,"android","101")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FuJinBean>() {
                    @Override
                    public void accept(FuJinBean bean) throws Exception {
                        callBack.success(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    public interface ModelCallBack {
        public void success(FuJinBean bean);
    }
}

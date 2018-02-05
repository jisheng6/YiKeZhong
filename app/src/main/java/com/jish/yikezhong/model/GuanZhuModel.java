package com.jish.yikezhong.model;

import com.jish.yikezhong.bean.DuanZiBean;
import com.jish.yikezhong.bean.GuanZhuBean;
import com.jish.yikezhong.retrofit.MainAlication;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adminjs on 2018/1/26.
 */

public class GuanZhuModel {
    public void getData(String uid,String token,final ModelCallBack callBack){
        MainAlication.api.getGuanZhu(uid,token,"android","101")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GuanZhuBean>() {
                    @Override
                    public void accept(GuanZhuBean bean) throws Exception {
                        callBack.success(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    public interface ModelCallBack {
        public void success(GuanZhuBean bean);
    }
}

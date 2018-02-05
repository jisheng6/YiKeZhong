package com.jish.yikezhong.model;

import com.jish.yikezhong.bean.ReDianBean;
import com.jish.yikezhong.retrofit.MainAlication;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adminjs on 2018/1/26.
 */

public class ReDianModel {
    public void getData(String uid,String page,final ModelCallBack callBack){
        MainAlication.api.getReDian(uid,page,"android","101")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ReDianBean>() {
                    @Override
                    public void accept(ReDianBean bean) throws Exception {
                        callBack.success(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    public interface ModelCallBack {
        public void success(ReDianBean bean);
    }
}

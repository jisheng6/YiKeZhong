package com.jish.yikezhong.present;

import android.view.View;

import com.jish.yikezhong.bean.DuanZiBean;
import com.jish.yikezhong.bean.ReMenBean;
import com.jish.yikezhong.model.DuanZiModel;
import com.jish.yikezhong.model.ReMenModel;
import com.jish.yikezhong.view.DuanZiView;
import com.jish.yikezhong.view.ReMenView;

/**
 * Created by Adminjs on 2018/1/26.
 */

public class ReMenPresenter {
    private ReMenModel model;
    private ReMenView view;

    public ReMenPresenter(ReMenView view) {
        this.view = view;
        this.model = new ReMenModel();
    }
    public void getData(String page,String token){
        model.getData(page,token, new ReMenModel.ModelCallBack() {
            @Override
            public void success(ReMenBean bean) {
                if(view != null){
                    view.success(bean);
                }
            }
        });
    }
}

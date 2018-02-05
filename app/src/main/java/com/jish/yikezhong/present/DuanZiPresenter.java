package com.jish.yikezhong.present;

import com.jish.yikezhong.bean.DuanZiBean;
import com.jish.yikezhong.bean.GuanZhuBean;
import com.jish.yikezhong.model.DuanZiModel;
import com.jish.yikezhong.model.GuanZhuModel;
import com.jish.yikezhong.view.DuanZiView;
import com.jish.yikezhong.view.GuanZhuView;

/**
 * Created by Adminjs on 2018/1/26.
 */

public class DuanZiPresenter {
    private DuanZiModel model;
    private DuanZiView view;

    public DuanZiPresenter(DuanZiView view) {
        this.view = view;
        this.model = new DuanZiModel();
    }
    public void getData(String page,String token){
        model.getData(page,token, new DuanZiModel.ModelCallBack() {
            @Override
            public void success(DuanZiBean bean) {
                if(view != null){
                    view.success(bean);
                }
            }
        });
    }
}

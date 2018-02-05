package com.jish.yikezhong.present;

import com.jish.yikezhong.bean.DuanZiBean;
import com.jish.yikezhong.bean.GuanZhuBean;
import com.jish.yikezhong.model.GuanZhuModel;
import com.jish.yikezhong.view.GuanZhuView;

/**
 * Created by Adminjs on 2018/1/26.
 */

public class GuanZhuPresenter {
    private GuanZhuModel model;
    private GuanZhuView view;

    public GuanZhuPresenter(GuanZhuView view) {
        this.view = view;
        this.model = new GuanZhuModel();
    }
    public void getData(String uid,String token){
        model.getData(uid,token, new GuanZhuModel.ModelCallBack() {
            @Override
            public void success(GuanZhuBean bean) {
                if(view != null){
                    view.success(bean);
                }
            }
        });
    }
}

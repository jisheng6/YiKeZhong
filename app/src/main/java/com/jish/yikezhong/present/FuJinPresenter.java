package com.jish.yikezhong.present;

import com.jish.yikezhong.bean.FuJinBean;
import com.jish.yikezhong.bean.ReMenBean;
import com.jish.yikezhong.model.FuJinModel;
import com.jish.yikezhong.model.ReMenModel;
import com.jish.yikezhong.view.FuJinView;
import com.jish.yikezhong.view.ReMenView;

/**
 * Created by Adminjs on 2018/1/26.
 */

public class FuJinPresenter {
    private FuJinModel model;
    private FuJinView view;

    public FuJinPresenter(FuJinView view) {
        this.view = view;
        this.model = new FuJinModel();
    }
    public void getData(String page,String token){
        model.getData(page,token, new FuJinModel.ModelCallBack() {
            @Override
            public void success(FuJinBean bean) {
                if(view != null){
                    view.success(bean);
                }
            }
        });
    }
}

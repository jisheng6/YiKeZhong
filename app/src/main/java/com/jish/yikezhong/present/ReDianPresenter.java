package com.jish.yikezhong.present;

import com.jish.yikezhong.bean.ReDianBean;
import com.jish.yikezhong.model.ReDianModel;
import com.jish.yikezhong.view.ReDianView;

/**
 * Created by Adminjs on 2018/1/26.
 */

public class ReDianPresenter {
    private ReDianModel model;
    private ReDianView view;

    public ReDianPresenter(ReDianView view) {
        this.view = view;
        this.model = new ReDianModel();
    }
    public void getData(String uid,String page){
        model.getData(uid, page, new ReDianModel.ModelCallBack() {
            @Override
            public void success(ReDianBean bean) {
                if(view != null){
                    view.success(bean);
                }
            }
        });
    }
}

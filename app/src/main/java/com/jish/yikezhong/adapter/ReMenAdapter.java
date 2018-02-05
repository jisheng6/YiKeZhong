package com.jish.yikezhong.adapter;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jish.yikezhong.R;
import com.jish.yikezhong.bean.DuanZiBean;
import com.jish.yikezhong.bean.ReDianBean;
import com.jish.yikezhong.bean.ReMenBean;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by Adminjs on 2017/11/18.
 */
public class ReMenAdapter extends XRecyclerView.Adapter<ReMenAdapter.IViewholder>{
    private Context context;
    private List<ReMenBean.DataBean>list;

    public ReMenAdapter(Context context) {
        this.context = context;
    }
    public void addData(ReMenBean bean){
        if(list == null){
            list = new ArrayList<>();
        }
        list.addAll(bean.getData());
        notifyDataSetChanged();
    }
    @Override
    public IViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.layout_remen, null);
        return new IViewholder(view);
    }

    @Override
    public void onBindViewHolder(final IViewholder holder, final int position) {

        holder.video.setUp(list.get(position).getVideoUrl(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class IViewholder extends XRecyclerView.ViewHolder{

        private final  JCVideoPlayerStandard video;

        public IViewholder(View itemView) {
            super(itemView);
            video = itemView.findViewById(R.id.jie);
        }
    }
}

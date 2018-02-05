package com.jish.yikezhong.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jish.yikezhong.R;
import com.jish.yikezhong.bean.FuJinBean;
import com.jish.yikezhong.bean.ReMenBean;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;


/**
 * Created by Adminjs on 2017/11/18.
 */
public class FuJinAdapter extends XRecyclerView.Adapter<FuJinAdapter.IViewholder>{
    private Context context;
    private List<FuJinBean.DataBean>list;

    public FuJinAdapter(Context context) {
        this.context = context;
    }
    public void addData(FuJinBean bean){
        if(list == null){
            list = new ArrayList<>();
        }
        list.addAll(bean.getData());
        notifyDataSetChanged();
    }
    @Override
    public IViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.layout_fujin, null);
        return new IViewholder(view);
    }

    @Override
    public void onBindViewHolder(final IViewholder holder, final int position) {

       holder.video.setUp(list.get(position).getVideoUrl(), JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"");

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class IViewholder extends XRecyclerView.ViewHolder{

        private final JCVideoPlayerStandard video;

        public IViewholder(View itemView) {
            super(itemView);
            video = itemView.findViewById(R.id.jievideo);
        }
    }
}

package com.jish.yikezhong.adapter;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Adminjs on 2018/1/26.
 */

public class DuanZiAdapter extends XRecyclerView.Adapter<DuanZiAdapter.IViewholder>{
    private Context context;
    private List<DuanZiBean.DataBean>list;

    public DuanZiAdapter(Context context) {
        this.context = context;
    }
    public void addData(DuanZiBean bean){
        if(list == null){
            list = new ArrayList<>();
        }
        list.addAll(bean.getData());
        notifyDataSetChanged();
    }
    private int a=0;
    private ObjectAnimator animator;
    private ObjectAnimator fanimator;
    private ObjectAnimator animator1;
    private ObjectAnimator fanimator1;
    private ObjectAnimator animator2;
    private ObjectAnimator fanimator2;
    private ObjectAnimator animator3;
    private ObjectAnimator fanimator3;
    private int xh=0;
    @Override
    public IViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.layout_duanzi, null);
        return new IViewholder(view);
    }

    @Override
    public void onBindViewHolder(final IViewholder holder, final int position) {
        holder.simple.setImageURI(list.get(position).getUser().getIcon());
        holder.title.setText(list.get(position).getContent());
        holder.time.setText(list.get(position).getCreateTime());
        holder.name.setText(list.get(position).getUser().getNickname());
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
        roundingParams.setRoundAsCircle(true);
        holder.simple.getHierarchy().setRoundingParams(roundingParams);
        final Map<Integer, Boolean> map = new HashMap();
        if(map.get(position)==null)
        {
            map.put(position,false);
        }
        holder.iv_frag1_item_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(map.get(position)==false)
                {
                    holder.ll_frag1_pingbi.setVisibility(View.VISIBLE);
                    holder.ll_frag1_copy.setVisibility(View.VISIBLE);
                    holder.ll_frag1_jubao.setVisibility(View.VISIBLE);

                    holder.iv_frag1_item_jia.setImageResource(R.drawable.icon_packup);
                    float translationX = holder.ll_frag1_jubao.getTranslationX();
                    ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(holder.ll_frag1_jubao,"translationX",translationX,-50f);

                    float translationX1 = holder.ll_frag1_copy.getTranslationX();
                    ObjectAnimator objectAnimator1=ObjectAnimator.ofFloat(holder.ll_frag1_copy,"translationX",translationX1,-100f);

                    float translationX2 = holder.ll_frag1_pingbi.getTranslationX();
                    ObjectAnimator objectAnimator2=ObjectAnimator.ofFloat(holder.ll_frag1_pingbi,"translationX",translationX2,-150f);

                    objectAnimator.setDuration(500);
                    objectAnimator1.setDuration(500);
                    objectAnimator2.setDuration(500);
                    objectAnimator.start();
                    objectAnimator1.start();
                    objectAnimator2.start();
                    map.put(position,true);
                }
                else if(map.get(position)==true)
                {
                    float translationX = holder.ll_frag1_pingbi.getTranslationX();
                    ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(holder.ll_frag1_pingbi,"translationX",translationX,0f);

                    float translationX1 = holder.ll_frag1_copy.getTranslationX();
                    ObjectAnimator objectAnimator1=ObjectAnimator.ofFloat(holder.ll_frag1_copy,"translationX",translationX1,0f);

                    float translationX2 = holder.ll_frag1_jubao.getTranslationX();
                    ObjectAnimator objectAnimator2=ObjectAnimator.ofFloat(holder.ll_frag1_jubao,"translationX",translationX2,0f);

                    objectAnimator.setDuration(500);
                    objectAnimator1.setDuration(500);
                    objectAnimator2.setDuration(500);
                    objectAnimator.start();
                    objectAnimator1.start();
                    objectAnimator2.start();
                    objectAnimator.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {
                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            holder.ll_frag1_pingbi.setVisibility(View.INVISIBLE);
                            holder.ll_frag1_copy.setVisibility(View.INVISIBLE);
                            holder.ll_frag1_jubao.setVisibility(View.INVISIBLE);
                            holder.iv_frag1_item_jia.setImageResource(R.drawable.icon_open);
                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {
                        }

                        @Override
                        public void onAnimationRepeat(Animator animator) {
                        }
                    });
                    map.put(position,false);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class IViewholder extends XRecyclerView.ViewHolder{
        private final ImageView iv_frag1_item_jia;
        private final LinearLayout ll_frag1_pingbi;
        private final LinearLayout ll_frag1_copy;
        private final LinearLayout ll_frag1_jubao;


        private final SimpleDraweeView simple;
        private final TextView title;
        private final TextView time;
        private final TextView name;

        public IViewholder(View itemView) {
           super(itemView);
            simple = itemView.findViewById(R.id.simple);
            title = itemView.findViewById(R.id.title);
            time = itemView.findViewById(R.id.time);
            name = itemView.findViewById(R.id.name);

            ll_frag1_pingbi = itemView.findViewById(R.id.ll_frag1_pingbi);
            ll_frag1_copy = itemView.findViewById(R.id.ll_frag1_copy);
            ll_frag1_jubao = itemView.findViewById(R.id.ll_frag1_jubao);
            iv_frag1_item_jia = itemView.findViewById(R.id.iv_frag1_item_jia);


       }
    }
}

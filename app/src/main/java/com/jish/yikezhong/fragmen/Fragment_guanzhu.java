package com.jish.yikezhong.fragmen;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jish.yikezhong.R;
import com.jish.yikezhong.adapter.GuanZhuAdapter;
import com.jish.yikezhong.bean.DuanZiBean;
import com.jish.yikezhong.bean.GuanZhuBean;
import com.jish.yikezhong.present.GuanZhuPresenter;
import com.jish.yikezhong.view.GuanZhuView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by Adminjs on 2018/1/25.
 */

public class Fragment_guanzhu extends Fragment implements GuanZhuView{
    @BindView(R.id.banner)
    ImageView banner;
    @BindView(R.id.recyclerview)
    XRecyclerView recyclerview;
    Unbinder unbinder;
//    private List<LunBean.DataBean> adt = new ArrayList<>();
//    private List<String> list;
    private GuanZhuPresenter presenter;
    private GuanZhuAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guanzhu, container, false);
        unbinder = ButterKnife.bind(this, view);
        SharedPreferences sp = getActivity().getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
        int uid = sp.getInt("uid", 0);
        String token = sp.getString("token", null);
//        getLun();
//        list = new ArrayList<>();
        presenter = new GuanZhuPresenter(this);
        presenter.getData(uid+"",token);
        adapter = new GuanZhuAdapter(getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerview.setLayoutManager(manager);
        recyclerview.setAdapter(adapter);
        recyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getActivity(),"正在刷新！",Toast.LENGTH_SHORT).show();
                recyclerview.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                recyclerview.loadMoreComplete();

            }
        });
        return view;
    }

//    private void getLun() {
//        MainAlication.api.getLun()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<LunBean>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(LunBean lunBean) {
//                        adt = lunBean.getData();
//                        for (int i = 0; i < adt.size(); i++) {
//                            list.add(adt.get(i).getIcon());
//                        }
//                        banner.setImageLoader(new GlideImageLoader());
//                        //设置集合
//                        banner.setImages(list);
//                        //banner执行完方法之后调用
//                        banner.start();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void success(GuanZhuBean bean) {
       adapter.addData(bean);
    }
    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}

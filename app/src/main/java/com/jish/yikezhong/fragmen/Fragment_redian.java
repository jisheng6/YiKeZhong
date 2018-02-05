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
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jish.yikezhong.R;
import com.jish.yikezhong.adapter.ReDianAdapter;
import com.jish.yikezhong.bean.LunBean;
import com.jish.yikezhong.bean.ReDianBean;
import com.jish.yikezhong.present.ReDianPresenter;
import com.jish.yikezhong.retrofit.GlideImageLoader;
import com.jish.yikezhong.retrofit.MainAlication;
import com.jish.yikezhong.view.ReDianView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adminjs on 2018/1/25.
 */

public class Fragment_redian extends Fragment implements ReDianView {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.recyclerview)
    XRecyclerView recyclerview;
    Unbinder unbinder;
    private List<LunBean.DataBean> adt = new ArrayList<>();
    private List<String> list;
    private ReDianPresenter presenter;
    private int page = 1;
    private ReDianAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_redian, container, false);
        unbinder = ButterKnife.bind(this, view);
        SharedPreferences sp = getActivity().getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
        int uid = sp.getInt("uid", 0);
        getLun();
        list = new ArrayList<>();
        presenter = new ReDianPresenter(this);
        presenter.getData(uid+"",""+page);
        adapter = new ReDianAdapter(getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerview.setLayoutManager(manager);
        recyclerview.setAdapter(adapter);
        recyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getActivity(),"正在刷新！！",Toast.LENGTH_SHORT).show();
                recyclerview.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                recyclerview.loadMoreComplete();

            }
        });
        return view;
    }
    private void getLun() {
        MainAlication.api.getLun()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LunBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LunBean lunBean) {
                        adt =  lunBean.getData();
                        for (int i=0;i<adt.size();i++){
                            list.add(adt.get(i).getIcon());
                        }
                        banner.setImageLoader(new GlideImageLoader());
                        //设置集合
                        banner.setImages(list);
                        //banner执行完方法之后调用
                        banner.start();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    @Override
    public void success(ReDianBean bean) {
        adapter.addData(bean);
    }
    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()){
            return;
        }
        super.getActivity().onBackPressed();
    }
    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

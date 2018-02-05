package com.jish.yikezhong.fragment;

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
import com.jish.yikezhong.adapter.DuanZiAdapter;
import com.jish.yikezhong.adapter.GuanZhuAdapter;
import com.jish.yikezhong.bean.DuanZiBean;
import com.jish.yikezhong.present.DuanZiPresenter;
import com.jish.yikezhong.present.GuanZhuPresenter;
import com.jish.yikezhong.view.DuanZiView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Adminjs on 2018/1/24.
 */

public class Fragment_duanzi extends Fragment implements DuanZiView{
    @BindView(R.id.xr)
    XRecyclerView xr;
    Unbinder unbinder;
    private DuanZiPresenter presenter;
    private DuanZiAdapter adapter;
    private int page=1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_duanzi, container, false);
        unbinder = ButterKnife.bind(this, view);
        SharedPreferences sp = getActivity().getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
        String token = sp.getString("token", null);
        presenter = new DuanZiPresenter(this);
        presenter.getData(page+"",token);
        adapter = new DuanZiAdapter(getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        xr.setLayoutManager(manager);
        xr.setAdapter(adapter);
        xr.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getActivity(),"正在刷新！",Toast.LENGTH_SHORT).show();
                xr.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                xr.loadMoreComplete();

            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void success(DuanZiBean bean) {
       adapter.addData(bean);
    }
}

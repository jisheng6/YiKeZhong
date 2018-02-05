package com.jish.yikezhong.fragmen;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jish.yikezhong.R;
import com.jish.yikezhong.adapter.ReMenAdapter;
import com.jish.yikezhong.bean.ReMenBean;
import com.jish.yikezhong.present.ReMenPresenter;
import com.jish.yikezhong.view.ReMenView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.http.PATCH;

/**
 * Created by Adminjs on 2018/1/28.
 */

public class Fragment_remen extends Fragment implements ReMenView{
    @BindView(R.id.xre)
    XRecyclerView xre;
    Unbinder unbinder;
    private ReMenPresenter presenter;
    private int page=1;
    private ReMenAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remen, container, false);
        unbinder = ButterKnife.bind(this, view);
        SharedPreferences sp = getActivity().getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
        String token = sp.getString("token", null);
        presenter = new ReMenPresenter(this);
        presenter.getData(page+"",token);
        adapter = new ReMenAdapter(getActivity());
        xre.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        xre.setAdapter(adapter);
        xre.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getActivity(),"正在刷新！！",Toast.LENGTH_SHORT).show();
                xre.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                xre.loadMoreComplete();

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
    public void success(ReMenBean bean) {
      adapter.addData(bean);
    }
}

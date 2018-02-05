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
import com.jish.yikezhong.adapter.FuJinAdapter;
import com.jish.yikezhong.adapter.ReMenAdapter;
import com.jish.yikezhong.bean.FuJinBean;
import com.jish.yikezhong.present.FuJinPresenter;
import com.jish.yikezhong.present.ReMenPresenter;
import com.jish.yikezhong.view.FuJinView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Adminjs on 2018/1/28.
 */

public class Fragment_fujin extends Fragment implements FuJinView{
    @BindView(R.id.xrecy)
    XRecyclerView xrecy;
    Unbinder unbinder;
    private FuJinPresenter presenter;
    private int page=1;
    private FuJinAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fujin, container, false);
        unbinder = ButterKnife.bind(this, view);
        SharedPreferences sp = getActivity().getSharedPreferences("sp_demo", Context.MODE_PRIVATE);
        String token = sp.getString("token", null);
        presenter = new FuJinPresenter(this);
        presenter.getData(page+"","3BD8EE2D043AA3D8DB30ACC236DCB7D0");
        adapter = new FuJinAdapter(getActivity());
        xrecy.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        xrecy.setAdapter(adapter);
        xrecy.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getActivity(),"正在刷新！！",Toast.LENGTH_SHORT).show();
                xrecy.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                xrecy.loadMoreComplete();

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
    public void success(FuJinBean bean) {
        adapter.addData(bean);
    }
}

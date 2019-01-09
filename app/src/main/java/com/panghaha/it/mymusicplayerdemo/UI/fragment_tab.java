package com.panghaha.it.mymusicplayerdemo.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.panghaha.it.mymusicplayerdemo.MainActivity;
import com.panghaha.it.mymusicplayerdemo.R;
import com.panghaha.it.mymusicplayerdemo.adapter.RecycleAdapter;
import com.panghaha.it.mymusicplayerdemo.adapter.RecyclerViewHeaderFooterAdapter;
import com.panghaha.it.mymusicplayerdemo.model.ViewModel;
import com.panghaha.it.mymusicplayerdemo.utils.DataUtils;
import com.panghaha.it.mymusicplayerdemo.widget.SpcaceDecoration;

import java.util.ArrayList;
import java.util.List;


public class fragment_tab extends Fragment {

    private View mview;
    private RecyclerView recyclerView;
    private RecycleAdapter adapter;
    private SwipeRefreshLayout swiprefresh;
    private RecyclerViewHeaderFooterAdapter headerFooterAdapter;
    List<ViewModel> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mview = inflater.inflate(R.layout.fragmenta,container,false);
        recyclerView = (RecyclerView) mview.findViewById(R.id.recycleview);
        swiprefresh = (SwipeRefreshLayout) mview.findViewById(R.id.swiprefresh);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false);
        adapter = new RecycleAdapter(getActivity());
        headerFooterAdapter = new RecyclerViewHeaderFooterAdapter(layoutManager,adapter);
        recyclerView.setLayoutManager(layoutManager);
        adapter.setAdapter(headerFooterAdapter);
        recyclerView.setAdapter(headerFooterAdapter);
        list = DataUtils.getTestlist();
        adapter.refreshData(list);

        init();
        return mview;
    }

    private void init() {
        swiprefresh.setColorSchemeColors(getResources().getColor(R.color.red2));
        swiprefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                swiprefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swiprefresh.setRefreshing(false);
                    }
                },1500);

            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy>0){//上滑隐藏底部
                    ((MainActivity)getActivity()).hideBottom();
                }

                if (dy<0){//下滑显示底部
                    ((MainActivity)getActivity()).showBottom();
                }
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();


    }
}

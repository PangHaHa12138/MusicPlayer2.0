package com.panghaha.it.mymusicplayerdemo.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.panghaha.it.mymusicplayerdemo.R;
import com.panghaha.it.mymusicplayerdemo.adapter.MeiziAdapter;
import com.panghaha.it.mymusicplayerdemo.model.meinv;
import com.panghaha.it.mymusicplayerdemo.utils.DataUtils;
import com.panghaha.it.mymusicplayerdemo.widget.SpcaceDecoration;

import java.util.ArrayList;
import java.util.List;

/***
 * ━━━━ Code is far away from ━━━━━━
 * 　　  () 　　　  ()
 * 　　  ( ) 　　　( )
 * 　　  ( ) 　　　( )
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　┻　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━ bug with the more protecting ━━━
 * <p/>
 * Created by PangHaHa12138 on 2017/7/5.
 */
public class GirleImgActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager layoutManager;
    private MeiziAdapter adapter;
    private List<meinv> list = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wdactivity);

        initview();
        initdata();
        adapter.setData(list);
    }


    private void initview() {
        recyclerView = (RecyclerView) findViewById(R.id.recycleviewww);
         layoutManager =
                //这里 3 代表三列 后面代表瀑布流朝向
                new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        adapter = new MeiziAdapter(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        SpcaceDecoration sc = new SpcaceDecoration(1);//设置间距
        recyclerView.addItemDecoration(sc);
        adapter.setOnItemClickListener(new MeiziAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(GirleImgActivity.this,"我被点击了"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initdata() {
        list = DataUtils.getMeizi();
    }


}

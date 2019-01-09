package com.panghaha.it.mymusicplayerdemo.UI;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.panghaha.it.mymusicplayerdemo.R;
import com.panghaha.it.mymusicplayerdemo.adapter.MusiclistAdapter;
import com.panghaha.it.mymusicplayerdemo.model.Song;
import com.panghaha.it.mymusicplayerdemo.service.MusicService;
import com.panghaha.it.mymusicplayerdemo.utils.MusicUtils;
import com.panghaha.it.mymusicplayerdemo.widget.CenterDialog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.panghaha.it.mymusicplayerdemo.UI.MusicPlayActivity.PARAM_MUSIC_LIST;

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
 * Created by PangHaHa12138 on 2017/7/4.
 */
public class MusicListActivity extends AppCompatActivity {

    private ListView musiclist;
    private SliderLayout sliderLayout;
    private List<Song> mlist = new ArrayList<>();
    private CenterDialog centerDialog;
    private View headview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musiclist);
        centerDialog = new CenterDialog(this,R.layout.centerdilog,new int[]{R.id.loading});
        centerDialog.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                initview();
                initdata();
            }
        },500);

        makeStatusBarTransparent();
    }

    /*设置透明状态栏*/
    private void makeStatusBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    private void initview() {
        musiclist = (ListView) findViewById(R.id.musiclist);
        headview = LayoutInflater.from(this).inflate(R.layout.musiclisthead, musiclist, false);
        sliderLayout = (SliderLayout) headview.findViewById(R.id.slider2);
        mlist = MusicUtils.getMusicData(this);
        centerDialog.dismiss();
        Intent intent_service = new Intent(this, MusicService.class);
        intent_service.putExtra(PARAM_MUSIC_LIST, (Serializable) mlist);
        startService(intent_service);
        MusiclistAdapter musiclistAdapter = new MusiclistAdapter(MusicListActivity.this, mlist);
        musiclist.addHeaderView(headview);
        musiclist.setAdapter(musiclistAdapter);

        musiclist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MusicListActivity.this, MusicPlayActivity.class);
                intent.putExtra(PARAM_MUSIC_LIST, (Serializable) mlist);
                intent.putExtra("position", position-1);
                intent.putExtra("song", mlist.get(position - 1).song);
                intent.putExtra("singer", mlist.get(position - 1).singer);
                intent.putExtra("image", mlist.get(position - 1).image);
                startActivity(intent);
            }
        });

    }

    private void initdata() {

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("舔狗舔到最后一无所有", R.drawable.mm1);
        file_maps.put("逐渐变成了万人敌", R.drawable.mmv2);
        file_maps.put("能力越大越讨人嫌", R.drawable.mmv1);
        file_maps.put("想在我头上换人骑", R.drawable.mm2);
        file_maps.put("那我天生就没有好人缘", R.drawable.amd3);
        file_maps.put("受到压榨", R.drawable.mmv3);
        file_maps.put("构造瞎话", R.drawable.mmm3);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(MusicListActivity.this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop);
//                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.ZoomOutSlide);
        sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setDuration(4000);
//        sliderLayout.addOnPageChangeListener(this);
    }

    @Override
    protected void onStop() {
        sliderLayout.stopAutoCycle();
        super.onStop();

    }
//
//    @Override
//    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//    }
//
//    @Override
//    public void onPageSelected(int position) {
//
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//
//    }
//
//    @Override
//    public void onSliderClick(BaseSliderView slider) {
//        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
//    }
}

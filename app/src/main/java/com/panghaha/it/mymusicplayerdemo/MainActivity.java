package com.panghaha.it.mymusicplayerdemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.panghaha.it.mymusicplayerdemo.UI.MusicPlayActivity;
import com.panghaha.it.mymusicplayerdemo.UI.fragment_A;
import com.panghaha.it.mymusicplayerdemo.UI.fragment_B;
import com.panghaha.it.mymusicplayerdemo.UI.fragment_C;
import com.panghaha.it.mymusicplayerdemo.UI.fragment_D;

public class MainActivity extends AppCompatActivity {

    private ImageView playnow;
    private TextView title;
    private BottomNavigationBar bottomNavigationBar;
    private fragment_A fragment_a;
    private fragment_B fragment_b;
    private fragment_C fragment_c;
    private fragment_D fragment_d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView) findViewById(R.id.titletext);
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_but);
        playnow = (ImageView) findViewById(R.id.playnow);
        AnimationDrawable animationDrawable = (AnimationDrawable) playnow.getDrawable();
        animationDrawable.start();

//        playnow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, MusicPlayActivity.class);
//                startActivity(intent);
//            }
//        });

        setDefaultfragment();
        setDefaultmode();
        checkPermission();
    }


    public void showBottom(){
        if (bottomNavigationBar.isHidden()) {
            bottomNavigationBar.show(true);
            bottomNavigationBar.setVisibility(View.VISIBLE);
        }
    }

    public void hideBottom(){
        if (!bottomNavigationBar.isHidden()){
            bottomNavigationBar.hide(true);
            bottomNavigationBar.postDelayed(new Runnable() {
                @Override
                public void run() {
                    bottomNavigationBar.setVisibility(View.GONE);
                }
            },500);
        }
    }

    private void checkPermission() {
        //检查权限（NEED_PERMISSION）是否被授权 PackageManager.PERMISSION_GRANTED表示同意授权
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //用户已经拒绝过一次，再次弹出权限申请对话框需要给用户一个解释
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission
                    .READ_EXTERNAL_STORAGE)) {
                Toast.makeText(this, "请开通权限读取本地歌曲", Toast.LENGTH_SHORT).show();
            }
            //申请权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 123);

        }
    }

    private void setDefaultmode() {

        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        bottomNavigationBar //值得一提，模式跟背景的设置都要在添加tab前面，不然不会有效果。
                .setActiveColor(R.color.white)//选中颜色 图标和文字
                .setInActiveColor("#8e8e8e")//默认未选择颜色
                .setBarBackgroundColor("#000000");//默认背景色


        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.t_actionbar_discover_selected, "发现音乐"))
                .addItem(new BottomNavigationItem(R.drawable.t_actionbar_music_selected, "我的音乐"))
                .addItem(new BottomNavigationItem(R.drawable.t_actionbar_friends_selected, "朋友"))
                .addItem(new BottomNavigationItem(R.drawable.tl, "我"))

                .initialise();//所有的设置需在调用该方法前完成


        bottomNavigationBar //设置lab点击事件
                .setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(int position) {
                        android.support.v4.app.FragmentManager fr = getSupportFragmentManager();
                        android.support.v4.app.FragmentTransaction ft = fr.beginTransaction();

                        switch (position) {

                            case 0:
                                ft.show(fragment_a).hide(fragment_b).hide(fragment_c).hide(fragment_d);
                                title.setText("发现音乐");
                                break;

                            case 1:
                                ft.show(fragment_b).hide(fragment_a).hide(fragment_c).hide(fragment_d);
                                title.setText("我的音乐");
                                break;

                            case 2:
                                ft.show(fragment_c).hide(fragment_b).hide(fragment_a).hide(fragment_d);
                                title.setText("朋友");
                                break;
                            case 3:
                                ft.show(fragment_d).hide(fragment_b).hide(fragment_c).hide(fragment_a);
                                title.setText("我");
                                break;
                        }

                        ft.commit();

                    }

                    @Override
                    public void onTabUnselected(int position) {

                    }

                    @Override
                    public void onTabReselected(int position) {

                    }
                });
    }

    private void setDefaultfragment() {

        android.support.v4.app.FragmentManager fr = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fr.beginTransaction();
        fragment_a = new fragment_A();
        ft.add(R.id.center, fragment_a);
        fragment_b = new fragment_B();
        ft.add(R.id.center, fragment_b).hide(fragment_b);
        fragment_c = new fragment_C();
        ft.add(R.id.center, fragment_c).hide(fragment_c);
        fragment_d = new fragment_D();
        ft.add(R.id.center, fragment_d).hide(fragment_d).commit();


    }

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

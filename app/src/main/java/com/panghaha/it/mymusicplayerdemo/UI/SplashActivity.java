package com.panghaha.it.mymusicplayerdemo.UI;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.panghaha.it.mymusicplayerdemo.MainActivity;
import com.panghaha.it.mymusicplayerdemo.R;

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
 * Created by PangHaHa12138 on 2017/6/23.
 */
public class SplashActivity extends AppCompatActivity {

    private ImageView splash;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash);

        splash = (ImageView) findViewById(R.id.splash);

        //方法一：开启一个子线程执行跳转任务

        new Thread(){
            @Override
            public void run() {

                super.run();
                try {

                    Thread.sleep(2000);
                    SplashActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            animateImage();
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();




    }
    //放大图片
    public void animateImage() {

        ObjectAnimator animatorX = ObjectAnimator.ofFloat(splash, "scaleX", 1f,
                1.2f);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(splash, "scaleY", 1f,
                1.2f);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(2000).play(animatorX).with(animatorY);
        set.start();

        set.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {

                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                SplashActivity.this.finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }
}

package com.panghaha.it.mymusicplayerdemo.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

import com.panghaha.it.mymusicplayerdemo.R;
import com.panghaha.it.mymusicplayerdemo.douyin.DouyinActivity;
import com.panghaha.it.mymusicplayerdemo.widget.CircleImageView;

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
 * Created by PangHaHa12138 on 2017/6/25.
 */
public class fragment_C extends Fragment implements View.OnClickListener{

    private View mview;
    private RelativeLayout pyq,tantan,pbl,ofo,mobai,douyin_go;
    private CircleImageView xuanzhuan;
    private RotateAnimation rotateAnimation;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mview = inflater.inflate(R.layout.fragment_c,container,false);

        pyq = (RelativeLayout) mview.findViewById(R.id.pengyouquan);
        tantan = (RelativeLayout) mview.findViewById(R.id.tantan6);
        pbl = (RelativeLayout) mview.findViewById(R.id.pubu);
        ofo = (RelativeLayout) mview.findViewById(R.id.ofoo);
        mobai = (RelativeLayout) mview.findViewById(R.id.mobai);
        douyin_go = (RelativeLayout) mview.findViewById(R.id.douyin_go);
        xuanzhuan = (CircleImageView) mview.findViewById(R.id.xuanzhuan);

        init();

        return mview;
    }

    private void init() {
        rotateAnimation = new RotateAnimation(0f,360f, Animation.RELATIVE_TO_SELF,
                0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        LinearInterpolator lin = new LinearInterpolator();
        rotateAnimation.setInterpolator(lin);//匀速
        rotateAnimation.setDuration(8000);//设置动画持续时间
        rotateAnimation.setRepeatCount(-1);//设置重复次数 -1不停
        rotateAnimation.setFillAfter(true);//动画执行完后是否停留在执行完的状态
        rotateAnimation.setStartOffset(10);//执行前的等待时间
        xuanzhuan.setAnimation(rotateAnimation);
        rotateAnimation.startNow();

        pyq.setOnClickListener(this);
        tantan.setOnClickListener(this);
        pbl.setOnClickListener(this);
        ofo.setOnClickListener(this);
        mobai.setOnClickListener(this);
        douyin_go.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.pengyouquan:
                Intent intent = new Intent(getActivity(),FishActivity.class);
                startActivity(intent);
                break;

            case R.id.tantan6:

                Intent intent2 = new Intent(getActivity(),TanTanActivity.class);
                startActivity(intent2);

                break;

            case R.id.pubu:

                Intent intent3 = new Intent(getActivity(),GirleImgActivity.class);
                startActivity(intent3);

                break;

            case R.id.ofoo:

                Intent intent4 = new Intent(getActivity(),OFOActivity.class);
                startActivity(intent4);

                break;

            case R.id.mobai:
                Intent intent5 = new Intent(getActivity(),MobikeActivity.class);
                startActivity(intent5);

                break;
            case R.id.douyin_go:
                Intent intent6 = new Intent(getActivity(),DouyinActivity.class);
                startActivity(intent6);

                break;


        }

    }
}

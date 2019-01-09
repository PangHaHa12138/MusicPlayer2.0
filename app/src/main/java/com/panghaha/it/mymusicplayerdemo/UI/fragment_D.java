package com.panghaha.it.mymusicplayerdemo.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.panghaha.it.mymusicplayerdemo.R;
import com.suke.widget.SwitchButton;

import cn.pedant.SweetAlert.SweetAlertDialog;

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
public class fragment_D extends Fragment implements View.OnClickListener{

    private View mview;
    private RelativeLayout aboutme,dashang,ty,clear,luo,night;
    private TextView huancun;
    private SwitchButton switchButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mview = inflater.inflate(R.layout.fragment_d,container,false);

        aboutme = (RelativeLayout) mview.findViewById(R.id.aboutme);
        dashang = (RelativeLayout) mview.findViewById(R.id.dashang);
        ty = (RelativeLayout) mview.findViewById(R.id.tongyong);
        clear = (RelativeLayout) mview.findViewById(R.id.clearcatch);
        luo = (RelativeLayout) mview.findViewById(R.id.luoxiangsheng);
        night = (RelativeLayout) mview.findViewById(R.id.night);
        huancun = (TextView) mview.findViewById(R.id.huancun);

         switchButton =(SwitchButton)mview.findViewById(R.id.switch_button);

//        switchButton.setChecked(false);
//        switchButton.isChecked();
//        switchButton.toggle();     //switch state
//        switchButton.toggle(true);//switch without animation
//        switchButton.setShadowEffect(true);//disable shadow effect
//        switchButton.setEnabled(false);//disable button
//        switchButton.setEnableEffect(false);//disable the switch animation
        switchButton.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                //TODO do your job

            }
        });

        aboutme.setOnClickListener(this);
        dashang.setOnClickListener(this);
        ty.setOnClickListener(this);
        clear.setOnClickListener(this);
//        night.setOnClickListener(this);
        luo.setOnClickListener(this);

        return mview;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.aboutme:

                Intent intent = new Intent(getActivity(),AboutmeActivity.class);
                startActivity(intent);

                break;

            case R.id.dashang:

                new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("确认打赏?")
                        .setContentText("打赏100元人民币")
                        .setConfirmText("Yes,do it!")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog
                                        .setTitleText("打赏!")
                                        .setContentText("已打赏100元人名币!")
                                        .setConfirmText("OK")
                                        .setConfirmClickListener(null)
                                        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                            }
                        })
                        .show();
                break;

            case R.id.tongyong:
                Intent intent3 = new Intent(getActivity(),JianLiActivity.class);
                startActivity(intent3);


                break;

            case R.id.clearcatch:

//                SweetAlertDialog pDialog = new SweetAlertDialog(getActivity(), SweetAlertDialog.PROGRESS_TYPE);
//                pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
//                pDialog.setTitleText("Loading");
//                pDialog.setCancelable(false);
//                pDialog.show();

                new SweetAlertDialog(getActivity(), SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("清除缓存成功!")
                        .setContentText("一共223M缓存被清理掉了")
                        .show();

                huancun.setText("0K");

                break;

            case R.id.luoxiangsheng:

                Intent intent2 = new Intent(getActivity(),MusicListActivity.class);
                startActivity(intent2);

                break;


        }

    }
}

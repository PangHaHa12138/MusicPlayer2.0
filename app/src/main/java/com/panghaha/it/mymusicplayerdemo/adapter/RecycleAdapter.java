package com.panghaha.it.mymusicplayerdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.panghaha.it.mymusicplayerdemo.R;
import com.panghaha.it.mymusicplayerdemo.UI.MusicListActivity;
import com.panghaha.it.mymusicplayerdemo.model.TestData;
import com.panghaha.it.mymusicplayerdemo.model.ViewModel;
import com.panghaha.it.mymusicplayerdemo.widget.CardSliderView;

import java.util.HashMap;

public class RecycleAdapter extends BaseIntermediary<ViewModel> {

    private static final int VIEW_TYPE_A = 1;
    private static final int VIEW_TYPE_B = 2;
    private static final int VIEW_TYPE_C = 3;

    private LayoutInflater inflater;
    private Context mcontext;


    public RecycleAdapter(Context context) {
        super(context);
        this.mcontext = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(ViewGroup viewGroup, int type) {

        if (type == VIEW_TYPE_A) {
            return new HolderA(inflater.inflate(R.layout.item_a, viewGroup, false), mcontext);
        } else if (type == VIEW_TYPE_B) {
            return new HolderB(inflater.inflate(R.layout.item_b, viewGroup, false), mcontext);
        } else if (type == VIEW_TYPE_C) {
            return new HolderC(inflater.inflate(R.layout.item_c, viewGroup, false), mcontext);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        int type = getItemViewType(position);
        if (type == VIEW_TYPE_A) {

        } else if (type == VIEW_TYPE_B) {

        } else if (type == VIEW_TYPE_C) {
            TestData data = (TestData) mDatas.get(position).content;
            HolderC holderC = (HolderC) viewHolder;
            holderC.setImg(data);
        }
    }


    @Override
    public int getItemViewType(int position) {

        if (position >= mDatas.size()) {
            return -1;
        }
        ViewModel model = mDatas.get(position);
        if ("A".equals(model.type)) {
            return VIEW_TYPE_A;
        } else if ("B".equals(model.type)) {
            return VIEW_TYPE_B;
        } else if ("C".equals(model.type)) {
            return VIEW_TYPE_C;
        }
        return super.getItemViewType(position);
    }

    private class HolderA extends RecyclerView.ViewHolder {

        private Context mContext;
        private SliderLayout mDemoSlider;
        public HolderA(View itemView, Context context) {
            super(itemView);
            this.mContext = context;
            mDemoSlider = (SliderLayout) itemView.findViewById(R.id.slider);
            setloopconfig();
        }

        private void setloopconfig() {

            HashMap<String,Integer> file_maps = new HashMap<>();
            file_maps.put("受到压榨 构造瞎话",R.drawable.pan13);
            file_maps.put("暗箱操作 仇恨加大",R.drawable.pan16);
            file_maps.put("But I don,t give a fuck",R.drawable.pan17);
            file_maps.put("没人能够让我趴下", R.drawable.pan20);
            file_maps.put("是因为 话不说透 差不多就", R.drawable.banner1);
            file_maps.put("观望着身边的 行尸走肉", R.drawable.banner2);
            file_maps.put("能力不够 成绩如旧", R.drawable.banner3);
            file_maps.put("绞尽脑汁也没悟透的flow", R.drawable.pan23);
            file_maps.put("你不看好我的show", R.drawable.pan34);
            file_maps.put("也能震撼你的soul", R.drawable.banner4);
            file_maps.put("这圈子没有兄弟,没有人会懂你", R.drawable.banner5);
            file_maps.put("只会拿刀捅你", R.drawable.banner6);

            for(String name : file_maps.keySet()){
                CardSliderView cardSliderView = new CardSliderView(mContext);
                // initialize a SliderLayout
                cardSliderView
                        .description(name)
                        .image(file_maps.get(name))
                        .setScaleType(BaseSliderView.ScaleType.CenterCrop);
                //add your extra information
                cardSliderView.bundle(new Bundle());
                cardSliderView.getBundle()
                        .putString("extra",name);
                mDemoSlider.addSlider(cardSliderView);
            }
            mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Default);
            mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            mDemoSlider.setCustomAnimation(new DescriptionAnimation());
            mDemoSlider.setDuration(4000);
        }
    }

    private class HolderB extends RecyclerView.ViewHolder {

        public HolderB(View itemView, Context context) {
            super(itemView);
        }
    }

    private class HolderC extends RecyclerView.ViewHolder {

        private ImageView img1,img2,img3;
        private TextView txt1,txt2,txt3;

        public HolderC(View itemView, Context context) {
            super(itemView);
            img1 = (ImageView) itemView.findViewById(R.id.img1);
            img2 = (ImageView) itemView.findViewById(R.id.img2);
            img3 = (ImageView) itemView.findViewById(R.id.img3);

            txt1 = (TextView) itemView.findViewById(R.id.txt1);
            txt2 = (TextView) itemView.findViewById(R.id.txt2);
            txt3 = (TextView) itemView.findViewById(R.id.txt3);
        }

        public void setImg(TestData data){

            img1.setImageResource(data.left_img);
            img2.setImageResource(data.center_img);
            img3.setImageResource(data.right_img);

            txt1.setText(data.left_txt);
            txt2.setText(data.center_txt);
            txt3.setText(data.right_txt);

        }


    }
}

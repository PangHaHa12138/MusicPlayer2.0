package com.panghaha.it.mymusicplayerdemo.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.panghaha.it.mymusicplayerdemo.R;
import com.panghaha.it.mymusicplayerdemo.utils.DisplayUtil;

public class CardSliderView extends BaseSliderView {

    public CardSliderView(Context context) {
        super(context);
    }

    @Override
    public View getView() {
        View v = LayoutInflater.from(mContext).inflate(R.layout.card_item,null);
        RoundImageView target = (RoundImageView)v.findViewById(R.id.roundimg);
        target.setRoundX(DisplayUtil.dp2px(mContext,6));
        bindEventAndShow(v, target);
        return v;
    }
}

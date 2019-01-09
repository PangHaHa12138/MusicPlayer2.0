package com.panghaha.it.mymusicplayerdemo.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class CustomLinearLayoutManager extends LinearLayoutManager {
    private double speedRatio;

    public CustomLinearLayoutManager(Context context) {
        super(context);
    }

    public CustomLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public CustomLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int a = super.scrollVerticallyBy((int) (speedRatio * dy), recycler, state);
        if (a == (int) (speedRatio * dy)) {
            return dy;
        }
        return a;
    }

    public void setSpeedRatio(double speedRatio) {
        this.speedRatio = speedRatio;
    }
}

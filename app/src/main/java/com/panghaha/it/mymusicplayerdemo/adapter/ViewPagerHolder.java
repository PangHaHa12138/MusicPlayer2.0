package com.panghaha.it.mymusicplayerdemo.adapter;

import android.content.Context;
import android.view.View;

import com.panghaha.it.mymusicplayerdemo.model.Song;

public interface ViewPagerHolder {
    /**
     *  创建View
     * @param context
     * @return
     */
    View createView(Context context);

    /**
     * 绑定数据
     * @param context
     * @param position
     * @param data
     */
    void onBind(Context context,int position,Song data);
}

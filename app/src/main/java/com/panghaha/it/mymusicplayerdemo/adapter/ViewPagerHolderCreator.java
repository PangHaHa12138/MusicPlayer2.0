package com.panghaha.it.mymusicplayerdemo.adapter;

public interface ViewPagerHolderCreator<M extends ViewPagerHolder> {
    /**
     * 创建ViewHolder
     * @return
     */
    public M createViewHolder();
}


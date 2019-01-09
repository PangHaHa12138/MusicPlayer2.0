package com.panghaha.it.mymusicplayerdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by sxk on 15/7/22.
 */
public interface IRecyclerViewIntermediary {
    public int getItemCount();
    public Object getItem(int position);
    public RecyclerView.ViewHolder getViewHolder(ViewGroup viewGroup, int type);
    public int getItemViewType(int position);
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position);

}

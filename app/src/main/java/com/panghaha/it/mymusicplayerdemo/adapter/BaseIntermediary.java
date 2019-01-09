package com.panghaha.it.mymusicplayerdemo.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName: BaseIntermediary
 * @Description: 基础的Intermediary
 * @Author liqi1
 * @Date 2016/5/28
 */
public abstract class BaseIntermediary<T> implements IRecyclerViewIntermediary {
    public List<T> mDatas = new ArrayList<>();
    public RecyclerViewHeaderFooterAdapter mAdapter;
    protected LayoutInflater mInflater;
    public Context mContext;
    private static final int position_key=0x000654a;

    private OnItemClickListener mOnItemClickListener;

    public BaseIntermediary(Context context){
        mContext=context;
        mInflater = LayoutInflater.from(context);
    }

    /**
     * Register a callback to be invoked when an item in this RecyclerView has
     * been clicked.
     *
     * @param listener The callback that will be invoked.
     */
    public void setOnItemClickListener(@Nullable OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    public void setAdapter(RecyclerViewHeaderFooterAdapter adapter) {
        this.mAdapter = adapter;
    }

    /**
     * 刷新数据
     *
     * @param list
     */
    public void refreshData(Collection<? extends T> list) {
        if (list != null) {
            mDatas.clear();
            mDatas.addAll(list);
            mAdapter.notifyDataSetChanged();
        }
    }
    /**
     * 追加数据
     *
     * @param list
     */
    public void addData(Collection<? extends T> list) {
        if (list != null) {
            mDatas.addAll(list);

            mAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 追加数据
     *
     * @param list
     */
    public void addData(int position,Collection<? extends T> list) {
        if (list != null) {
            mDatas.addAll(position,list);
            mAdapter.notifyDataSetChanged();
        }
    }
    /**
     * 追加数据
     *
     * @param data
     */
    public void addData(T data, int position) {
        if (data != null) {
            mDatas.add(position, data);
            mAdapter.notifyDataSetChanged();
        }
    }

    public void removeData(T data){
        if (mDatas != null && mDatas.contains(data)){
            mDatas.remove(data);
            mAdapter.notifyDataSetChanged();
        }
    }

    public void removeData(int position){
        if (mDatas !=null && mDatas.size()>position){
            mDatas.remove(position);
            mAdapter.notifyDataSetChanged();
        }
    }
    protected View inflate(int resId, ViewGroup parent){
        return  mInflater.inflate(resId, parent, false);
    }

    public Context getContext() {
        return mContext;
    }


    protected String getString(int pResId) {
        return mContext.getString(pResId);
    }

    protected Resources getResources() {
        return mContext.getResources();
    }

    @Override
    public abstract RecyclerView.ViewHolder getViewHolder(ViewGroup viewGroup, int type);

    @Override
    public abstract void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position);

    public interface OnItemClickListener{
        /**
         * Callback method to be invoked when an item in this BaseIntermediary has
         * been clicked.
         * <p>
         *
         * @param intermediary The BaseIntermediary of the RecyclerView.
         * @param itemView The view within the RecyclerView that was clicked (this
         *            will be a view provided by the BaseIntermediary)
         * @param position The position of the view in the adapter.
         */
        void onItemClick(BaseIntermediary intermediary, View itemView, int position);
    }
}

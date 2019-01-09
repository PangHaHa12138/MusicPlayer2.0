package com.panghaha.it.mymusicplayerdemo.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by xianting on 16/12/28.
 */
public abstract class BaseViewHolder<K> extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews;
    protected View mItemView;

    protected Context mContext;
    protected ViewHolderCallback viewHolderCallback;


    public BaseViewHolder(Context context, View itemView) {
        super(itemView);
        mContext = context;
        mItemView = itemView;
        mViews = new SparseArray<>();
    }

    public BaseViewHolder(Context context, int layoutResId, ViewGroup viewGroup) {
        this(context,LayoutInflater.from(context).inflate(layoutResId, viewGroup, false));
    }



    public abstract void renderData(@Nullable K k);



    public static class EmptyViewHolder extends BaseViewHolder{

        public EmptyViewHolder(Context context, View itemView) {
            super(context, itemView);
        }

        public EmptyViewHolder(Context context) {
            super(context, new View( context ));
            itemView.setVisibility( View.GONE );
        }

        public EmptyViewHolder(Context context, int layoutResId, ViewGroup viewGroup) {
            super( context, layoutResId, viewGroup );
        }

        @Override
        public void renderData(Object o) {
                // do nothing
        }
    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mItemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mItemView;
    }


    /**
     * 设置TextView的值
     *
     * @param viewId
     * @param text
     * @return
     */
    public BaseViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public BaseViewHolder setText(int viewId, SpannableString text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public BaseViewHolder setImageResource(int viewId, int resId) {
        ImageView view = getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    public BaseViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    public BaseViewHolder setImageDrawable(int viewId, Drawable drawable) {
        ImageView view = getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    public BaseViewHolder setBackgroundColor(int viewId, int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public BaseViewHolder setBackgroundRes(int viewId, int backgroundRes) {
        View view = getView(viewId);
        view.setBackgroundResource(backgroundRes);
        return this;
    }

    public BaseViewHolder setTextColor(int viewId, int textColor) {
        TextView view = getView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    public BaseViewHolder setTextColorRes(int viewId, int textColorRes) {
        TextView view = getView(viewId);
        view.setTextColor(mContext.getResources().getColor(textColorRes));
        return this;
    }

    @SuppressLint("NewApi")
    public BaseViewHolder setAlpha(int viewId, float value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getView(viewId).setAlpha(value);
        } else {
            // Pre-honeycomb hack to set Alpha value
            AlphaAnimation alpha = new AlphaAnimation(value, value);
            alpha.setDuration(0);
            alpha.setFillAfter(true);
            getView(viewId).startAnimation(alpha);
        }
        return this;
    }

    public BaseViewHolder setVisible(int viewId, boolean visible) {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    public BaseViewHolder setVisibleWithSpace(int viewId, boolean visible) {
        View view = getView(viewId);
            view.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);

        return this;
    }

    public BaseViewHolder linkify(int viewId) {
        TextView view = getView(viewId);
        Linkify.addLinks(view, Linkify.ALL);
        return this;
    }

    public BaseViewHolder setTypeface(Typeface typeface, int... viewIds) {
        for (int viewId : viewIds) {
            TextView view = getView(viewId);
            view.setTypeface(typeface);
            view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }
        return this;
    }

    public BaseViewHolder setProgress(int viewId, int progress) {
        ProgressBar view = getView(viewId);
        view.setProgress(progress);
        return this;
    }

    public BaseViewHolder setProgress(int viewId, int progress, int max) {
        ProgressBar view = getView(viewId);
        view.setMax(max);
        view.setProgress(progress);
        return this;
    }

    public BaseViewHolder setMax(int viewId, int max) {
        ProgressBar view = getView(viewId);
        view.setMax(max);
        return this;
    }

    public BaseViewHolder setRating(int viewId, float rating) {
        RatingBar view = getView(viewId);
        view.setRating(rating);
        return this;
    }

    public BaseViewHolder setRating(int viewId, float rating, int max) {
        RatingBar view = getView(viewId);
        view.setMax(max);
        view.setRating(rating);
        return this;
    }

    public BaseViewHolder setTag(int viewId, Object tag) {
        View view = getView(viewId);
        view.setTag(tag);
        return this;
    }

    public BaseViewHolder setTag(int viewId, int key, Object tag) {
        View view = getView(viewId);
        view.setTag(key, tag);
        return this;
    }

    public BaseViewHolder setChecked(int viewId, boolean checked) {
        Checkable view = (Checkable) getView(viewId);
        view.setChecked(checked);
        return this;
    }

    /**
     * 关于事件的
     */
    public BaseViewHolder setOnClickListener(int viewId,
                                             View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    public BaseViewHolder setOnTouchListener(int viewId,
                                             View.OnTouchListener listener) {
        View view = getView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    public BaseViewHolder setOnLongClickListener(int viewId,
                                                 View.OnLongClickListener listener) {
        View view = getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }

    public BaseViewHolder setViewHolderCallBack(ViewHolderCallback viewHolderCallBack) {
        this.viewHolderCallback = viewHolderCallBack;
        return this;
    }

    /**
     * @Description:viewholder中操作回调接口
     */
    public interface ViewHolderCallback<K> {
        void callback(K params);
    }

    public Context getContext() {
        return mContext;
    }

    public String getString(int resId){
       return getContext().getString( resId );
    }
}

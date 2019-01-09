package com.panghaha.it.mymusicplayerdemo.adapter;


import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Will on 2/8/2015.
 */
public class RecyclerViewHeaderFooterAdapter extends RecyclerView.Adapter {

    public static final int TYPE_MANAGER_OTHER = 0;
    public static final int TYPE_MANAGER_LINEAR = 1;
    public static final int TYPE_MANAGER_GRID = 2;
    public static final int TYPE_MANAGER_STAGGERED_GRID = 3;


    public static final int TYPE_HEADER = 7898;
    public static final int TYPE_FOOTER = 7899;

    private List<View> mHeaders = new ArrayList<>();
    private List<View> mFooters = new ArrayList<>();

    private int mManagerType;
    private RecyclerView.LayoutManager mManager;
    private IRecyclerViewIntermediary mIntermediary;
    private CustomLinearLayoutManager customLinearLayoutManager;

    public RecyclerViewHeaderFooterAdapter(RecyclerView.LayoutManager manager, IRecyclerViewIntermediary intermediary) {
        setManager(manager);
        this.mIntermediary = intermediary;
    }

    /**
     *  SrcollVerstical 设置滑动速度默认
     * @param mContext
     * @param mIntermediary
     */
    public RecyclerViewHeaderFooterAdapter(Context mContext, IRecyclerViewIntermediary mIntermediary) {
        this.mIntermediary = mIntermediary;
        customLinearLayoutManager = new CustomLinearLayoutManager(mContext);
        customLinearLayoutManager.setSpeedRatio(0.82);  //默认滚动速度
        setManager(customLinearLayoutManager);
    }

    /**
     *  SrcollVerstical 设置滑动速度
     * @param mContext
     * @param mIntermediary
     * @param scrollSpeed //速度，默认为0.82
     */
    public RecyclerViewHeaderFooterAdapter(Context mContext, IRecyclerViewIntermediary mIntermediary, Double scrollSpeed) {
        this.mIntermediary = mIntermediary;
        customLinearLayoutManager = new CustomLinearLayoutManager(mContext);
        customLinearLayoutManager.setSpeedRatio(scrollSpeed == 0 ? 0.82 : scrollSpeed);  //默认滚动速度
        setManager(customLinearLayoutManager);
    }

    public void setLayoutManager(RecyclerView.LayoutManager manager) {
        setManager(manager);
    }

    public CustomLinearLayoutManager getCustomLinearLayoutManager() {
        return customLinearLayoutManager;
    }

    private void setManager(RecyclerView.LayoutManager manager) {
        mManager = manager;
        if (mManager instanceof GridLayoutManager) {
            mManagerType = TYPE_MANAGER_GRID;
            ((GridLayoutManager) mManager).setSpanSizeLookup(mSpanSizeLookup);
        } else if (mManager instanceof LinearLayoutManager) {
            mManagerType = TYPE_MANAGER_LINEAR;
        } else if (mManager instanceof StaggeredGridLayoutManager) {
            mManagerType = TYPE_MANAGER_STAGGERED_GRID;
            ((StaggeredGridLayoutManager) mManager).setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        } else {
            mManagerType = TYPE_MANAGER_OTHER;
        }
    }

    public int getManagerType() {
        return mManagerType;
    }

    public int getHeadersSize() {
        return mHeaders.size();
    }

    public int getFootersSize() {
        return mFooters.size();
    }

    public int getGridSpan(int position) {
        if (isHeader(position) || isFooter(position)) {
            return getSpan();
        }
        position -= mHeaders.size();
        if (mIntermediary.getItem(position) instanceof IGridItem) {
            return ((IGridItem) mIntermediary.getItem(position)).getGridSpan();
        }
        return 1;
    }

    private int getSpan() {
        if (mManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) mManager).getSpanCount();
        } else if (mManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) mManager).getSpanCount();
        }
        return 1;
    }

    private GridLayoutManager.SpanSizeLookup mSpanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
        @Override
        public int getSpanSize(int position) {
            return getGridSpan(position);
        }
    };


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {
        //if our position is one of our items (this comes from getItemViewType(int position) below)
        if (type != TYPE_HEADER && type != TYPE_FOOTER) {
            return mIntermediary.getViewHolder(viewGroup, type);
            //else we have a header/footer
        } else {
            //create a new framelayout, or inflate from a resource
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            //make sure it fills the space
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            return new HeaderFooterViewHolder(frameLayout);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder vh, int position) {
        //check what type of view our position is
        if (isHeader(position)) {
            View v = mHeaders.get(position);
            //add our view to a header view and display it
            prepareHeaderFooter((HeaderFooterViewHolder) vh, v);
        } else if (isFooter(position)) {
            View v = mFooters.get(position - mIntermediary.getItemCount() - mHeaders.size());
            //add our view to a footer view and display it
            prepareHeaderFooter((HeaderFooterViewHolder) vh, v);
        } else {
            //it's one of our items, display as required
            mIntermediary.onBindViewHolder(vh, position - mHeaders.size());
        }
    }

    public void prepareHeaderFooter(HeaderFooterViewHolder vh, View view) {

        //if it's a staggered grid, span the whole layout
        if (mManagerType == TYPE_MANAGER_STAGGERED_GRID) {
            StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.setFullSpan(true);
            vh.itemView.setLayoutParams(layoutParams);
        }

        //if the view already belongs to another layout, remove it
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }

        //empty out our FrameLayout and replace with our header/footer
        vh.base.removeAllViews();
        vh.base.addView(view);

    }

    private boolean isHeader(int position) {
        return (position < mHeaders.size());
    }

    private boolean isFooter(int position) {
        return (position >= mHeaders.size() + mIntermediary.getItemCount());
    }


    @Override
    public int getItemCount() {
        return mHeaders.size() + mIntermediary.getItemCount() + mFooters.size();
    }

    @Override
    public int getItemViewType(int position) {
        //check what type our position is, based on the assumption that the order is headers > items > footers
        if (isHeader(position)) {
            return TYPE_HEADER;
        } else if (isFooter(position)) {
            return TYPE_FOOTER;
        }
        int type = mIntermediary.getItemViewType(position-getHeadersSize());
        if (type == TYPE_HEADER || type == TYPE_FOOTER) {
            throw new IllegalArgumentException("Item type cannot equal " + TYPE_HEADER + " or " + TYPE_FOOTER);
        }
        return type;
    }

    //add a header to the adapter
    public void addHeader(View header) {
        if (!mHeaders.contains(header)) {
            mHeaders.add(header);
            //animate
            notifyItemInserted(mHeaders.size() - 1);
        }
    }

    public View getFooterView(){
        return getFooter(0) ;
    }

    public View getHeader(int position){
        if (position<mHeaders.size()){
            return mHeaders.get(position);
        }
        return null;
    }

    public View getFooter(int position){
        if (position<mFooters.size()){
            return mFooters.get(position);
        }
        return null;
    }

    //remove a header from the adapter
    public void removeHeader(View header) {
        if (mHeaders.contains(header)) {
            //animate
            notifyItemRemoved(mHeaders.indexOf(header));
            mHeaders.remove(header);
        }
    }

    //add a footer to the adapter
    public void addFooter(View footer) {
        if (!mFooters.contains(footer)) {
            mFooters.add(footer);
            //animate
            notifyItemInserted(mHeaders.size() + mIntermediary.getItemCount() + mFooters.size() - 1);
        }
    }

    //remove a footer from the adapter
    public void removeFooter(View footer) {
        if (mFooters.contains(footer)) {
            //animate
            notifyItemRemoved(mHeaders.size() + mIntermediary.getItemCount() + mFooters.indexOf(footer));
            mFooters.remove(footer);
        }
    }

    //our header/footer RecyclerView.ViewHolder is just a FrameLayout
    public static class HeaderFooterViewHolder extends RecyclerView.ViewHolder {
        FrameLayout base;

        public HeaderFooterViewHolder(View itemView) {
            super(itemView);
            base = (FrameLayout) itemView;
        }
    }

}

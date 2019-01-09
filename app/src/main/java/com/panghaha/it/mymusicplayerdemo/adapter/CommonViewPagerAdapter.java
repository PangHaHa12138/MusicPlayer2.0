package com.panghaha.it.mymusicplayerdemo.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.panghaha.it.mymusicplayerdemo.model.Song;

import java.util.List;

public class CommonViewPagerAdapter extends PagerAdapter {
    private List<Song> mDatas;
    private ViewPagerHolderCreator mCreator;//ViewHolder生成器

    public CommonViewPagerAdapter(ViewPagerHolderCreator creator) {

        mCreator = creator;
    }

    public void setDataList(List<Song> datas){
        this.mDatas = datas;
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return mDatas == null ? 0:mDatas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //重点就在这儿了，不再是把布局写死，而是用接口提供的布局
        // 也不在这里绑定数据，数据绑定交给Api调用者。
        View view = getView(position,null,container);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    /**
     * 获取viewPager 页面展示View
     * @param position
     * @param view
     * @param container
     * @return
     */
    private View getView(int position,View view ,ViewGroup container){

        ViewPagerHolder holder =null;
        if(view == null){
            //创建Holder
            holder = mCreator.createViewHolder();
            view = holder.createView(container.getContext());
            view.setTag(holder);
        }else{
            holder = (ViewPagerHolder) view.getTag();
        }
        if(holder!=null && mDatas!=null && mDatas.size()>0){
            // 数据绑定
            holder.onBind(container.getContext(),position,mDatas.get(position));
        }

        return view;
    }
}

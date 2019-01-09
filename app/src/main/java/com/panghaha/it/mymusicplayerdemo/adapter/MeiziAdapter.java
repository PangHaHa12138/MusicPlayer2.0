package com.panghaha.it.mymusicplayerdemo.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.panghaha.it.mymusicplayerdemo.R;
import com.panghaha.it.mymusicplayerdemo.model.meinv;

import java.util.ArrayList;
import java.util.List;

/***
 * ━━━━ Code is far away from ━━━━━━
 * 　　  () 　　　  ()
 * 　　  ( ) 　　　( )
 * 　　  ( ) 　　　( )
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　┻　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━ bug with the more protecting ━━━
 * <p/>
 * Created by PangHaHa12138 on 2017/7/3.
 */
public class MeiziAdapter extends RecyclerView.Adapter<MeiziAdapter.ViewHolder> implements View.OnClickListener{

    private List<meinv> mlist= new ArrayList<>();

    private Context context;
    private static final int TYPE_HEADER = 0, TYPE_ITEM = 1, TYPE_FOOT = 2;
    private View headView;
    private View footView;
    private boolean isAddFoot = false;
    private boolean isAddHead = false;
    private int headViewSize = 0;
    private int footViewSize = 0;

    private OnItemClickListener mOnItemClickListener = null;



    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public MeiziAdapter(Context context){

        this.context = context;
    }

    public void setData(List<meinv> list){
        if (list!=null){
            mlist.clear();
            mlist.addAll(list);
            notifyDataSetChanged();
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView meizi;
        CardView cardView;
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            textView = (TextView) itemView.findViewById(R.id.hahtextt);
            meizi = (ImageView) itemView.findViewById(R.id.meizitu);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.recycleitem,parent,false);
        view.setOnClickListener(this);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(position);
        meinv meinv = mlist.get(position);
        holder.meizi.setImageResource(meinv.getImageid());
        holder.textView.setText(meinv.getMsg());

    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view , int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }



    @Override
    public int getItemCount() {

        return mlist.size();
    }
}

package com.panghaha.it.mymusicplayerdemo.UI;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.panghaha.it.mymusicplayerdemo.R;
import com.panghaha.it.mymusicplayerdemo.flingswipe.SwipeFlingAdapterView;
import com.panghaha.it.mymusicplayerdemo.swipecards.CardAdapter;
import com.panghaha.it.mymusicplayerdemo.swipecards.CardMode;

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
 * Created by PangHaHa12138 on 2017/7/4.
 */
public class TanTanActivity extends AppCompatActivity {

    private ArrayList<CardMode> al;
    private CardAdapter adapter;
    private int i;
    private SwipeFlingAdapterView flingContainer;
    private List<List<Integer>> list = new ArrayList<>();
    private ImageView left, right;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        left = (ImageView) findViewById(R.id.left);
        right = (ImageView) findViewById(R.id.right);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                left();
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                right();
            }
        });
        al = new ArrayList<>();

        for (int i = 0; i < imageurl2.length; i++) {
            List<Integer> s = new ArrayList<>();
            s.add(imageurl2[i]);
            list.add(s);
        }
        List<String> yi;
        al.add(new CardMode("小姐姐", 16, list.get(0)));
        al.add(new CardMode("小姐姐", 21, list.get(1)));
        al.add(new CardMode("小姐姐", 18, list.get(2)));
        al.add(new CardMode("小姐姐", 21, list.get(3)));
        al.add(new CardMode("小姐姐", 23, list.get(4)));
        al.add(new CardMode("小姐姐", 21, list.get(5)));
        al.add(new CardMode("小姐姐", 21, list.get(6)));
        al.add(new CardMode("小姐姐", 25, list.get(7)));
        al.add(new CardMode("小姐姐", 21, list.get(8)));
        al.add(new CardMode("小姐姐", 23, list.get(9)));
        al.add(new CardMode("小姐姐", 21, list.get(10)));
        al.add(new CardMode("小姐姐", 22, list.get(11)));
        al.add(new CardMode("小姐姐", 21, list.get(12)));
        al.add(new CardMode("小姐姐", 21, list.get(13)));
        al.add(new CardMode("小姐姐", 25, list.get(14)));
        al.add(new CardMode("小姐姐", 21, list.get(15)));
        al.add(new CardMode("小姐姐", 24, list.get(16)));
        al.add(new CardMode("小姐姐", 21, list.get(17)));
        al.add(new CardMode("小姐姐", 21, list.get(18)));
        al.add(new CardMode("小姐姐", 22, list.get(19)));
        al.add(new CardMode("小姐姐", 21, list.get(20)));
        al.add(new CardMode("小姐姐", 22, list.get(21)));
        al.add(new CardMode("小姐姐", 21, list.get(22)));
        al.add(new CardMode("小姐姐", 23, list.get(23)));
        al.add(new CardMode("小姐姐", 21, list.get(24)));
        al.add(new CardMode("小姐姐", 21, list.get(25)));
        al.add(new CardMode("小姐姐", 25, list.get(26)));
        al.add(new CardMode("小姐姐", 21, list.get(27)));
        al.add(new CardMode("小姐姐", 26, list.get(28)));
        al.add(new CardMode("小姐姐", 21, list.get(29)));
        al.add(new CardMode("小姐姐", 21, list.get(30)));
        al.add(new CardMode("小姐姐", 24, list.get(31)));
        al.add(new CardMode("小姐姐", 21, list.get(32)));
        al.add(new CardMode("小姐姐", 23, list.get(33)));
        al.add(new CardMode("小姐姐", 22, list.get(34)));
        al.add(new CardMode("小姐姐", 21, list.get(35)));
        al.add(new CardMode("小姐姐", 21, list.get(36)));
        al.add(new CardMode("小姐姐", 21, list.get(37)));
        al.add(new CardMode("小姐姐", 20, list.get(38)));
        al.add(new CardMode("小姐姐", 21, list.get(39)));
        al.add(new CardMode("小姐姐", 20, list.get(40)));
        al.add(new CardMode("小姐姐", 21, list.get(41)));
        al.add(new CardMode("小姐姐", 20, list.get(42)));
        al.add(new CardMode("小姐姐", 21, list.get(43)));
        al.add(new CardMode("小姐姐", 20, list.get(44)));
        al.add(new CardMode("小姐姐", 20, list.get(45)));
        al.add(new CardMode("小姐姐", 21, list.get(46)));
        al.add(new CardMode("小姐姐", 21, list.get(47)));
        al.add(new CardMode("小姐姐", 25, list.get(48)));
        al.add(new CardMode("小姐姐", 21, list.get(49)));
        al.add(new CardMode("小姐姐", 23, list.get(50)));
        al.add(new CardMode("小姐姐", 21, list.get(51)));
        al.add(new CardMode("小姐姐", 21, list.get(52)));
        al.add(new CardMode("小姐姐", 23, list.get(53)));
        al.add(new CardMode("小姐姐", 21, list.get(54)));
        al.add(new CardMode("小姐姐", 23, list.get(55)));
        al.add(new CardMode("小姐姐", 21, list.get(56)));

        adapter = new CardAdapter(this, al);
        flingContainer = (SwipeFlingAdapterView) findViewById(R.id.frame);
        flingContainer.setAdapter(adapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                al.remove(0);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onLeftCardExit(Object dataObject) {
                makeToast(TanTanActivity.this, "不喜欢");
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                makeToast(TanTanActivity.this, "喜欢");
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                al.add(new CardMode("循环测试", 18, list.get(itemsInAdapter % imageurl2.length - 1)));
                adapter.notifyDataSetChanged();
                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                try {
                    View view = flingContainer.getSelectedView();
                    view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
                    view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
                makeToast(TanTanActivity.this, "点击图片");
            }
        });

    }

    static void makeToast(Context ctx, String s) {
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }


    public void right() {
        flingContainer.getTopCardListener().selectRight();
    }

    public void left() {
        flingContainer.getTopCardListener().selectLeft();
    }

    public final int[] imageurl2 = new int[]{
            R.drawable.ol1,
            R.drawable.ol2,
            R.drawable.ol3,
            R.drawable.ol4,
            R.drawable.ol5,
            R.drawable.ol6,
            R.drawable.ol7,
            R.drawable.ol8,
            R.drawable.ol9,
            R.drawable.ol10,
            R.drawable.ol11,
            R.drawable.ol12,
            R.drawable.ol13,
            R.drawable.ol14,
            R.drawable.ol15,
            R.drawable.ol16,
            R.drawable.ol17,
            R.drawable.ol18,
            R.drawable.ol19,
            R.drawable.ol20,
            R.drawable.ol21,
            R.drawable.ol22,
            R.drawable.ol23,
            R.drawable.ol24,
            R.drawable.ol25,
            R.drawable.ol26,
            R.drawable.ol27,
            R.drawable.ol28,
            R.drawable.ol29,
            R.drawable.ol30,
            R.drawable.ol31,
            R.drawable.ol32,
            R.drawable.ol33,
            R.drawable.ol34,
            R.drawable.ol35,
            R.drawable.ol36,
            R.drawable.ol37,
            R.drawable.ol38,
            R.drawable.ol39,
            R.drawable.ol40,
            R.drawable.ol41,
            R.drawable.ol42,
            R.drawable.ol43,
            R.drawable.ol44,
            R.drawable.ol45,
            R.drawable.ol46,
            R.drawable.ol47,
            R.drawable.ol48,
            R.drawable.ol49,
            R.drawable.ol50,
            R.drawable.ol51,
            R.drawable.ol52,
            R.drawable.ol53,
            R.drawable.ol54,
            R.drawable.ol55,
            R.drawable.ol56,
            R.drawable.ol57,
           };

    public final String[] imageUrls = new String[]{
            "http://img.my.csdn.net/uploads/201309/01/1378037235_3453.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037235_7476.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037235_9280.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037234_3539.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037234_6318.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037194_2965.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037193_1687.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037193_1286.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037192_8379.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037178_9374.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037177_1254.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037177_6203.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037152_6352.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037151_9565.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037151_7904.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037148_7104.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037129_8825.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037128_5291.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037128_3531.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037127_1085.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037095_7515.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037094_8001.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037093_7168.jpg",
            "http://img.my.csdn.net/uploads/201309/01/1378037091_4950.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949643_6410.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949642_6939.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949630_4505.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949630_4593.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949629_7309.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949629_8247.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949615_1986.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949614_8482.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949614_3743.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949614_4199.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949599_3416.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949599_5269.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949598_7858.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949598_9982.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949578_2770.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949578_8744.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949577_5210.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949577_1998.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949482_8813.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949481_6577.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949480_4490.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949455_6792.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949455_6345.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949442_4553.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949441_8987.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949441_5454.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949454_6367.jpg",
            "http://img.my.csdn.net/uploads/201308/31/1377949442_4562.jpg"};
}

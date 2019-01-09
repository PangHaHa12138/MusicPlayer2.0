package com.panghaha.it.mymusicplayerdemo.utils;


import com.panghaha.it.mymusicplayerdemo.R;
import com.panghaha.it.mymusicplayerdemo.model.Song;
import com.panghaha.it.mymusicplayerdemo.model.TestData;
import com.panghaha.it.mymusicplayerdemo.model.ViewModel;
import com.panghaha.it.mymusicplayerdemo.model.meinv;

import java.util.ArrayList;
import java.util.List;

/**
 * 本地音乐
 */
public class DataUtils {

    public static int Type_Like = 1;
    public static int Type_Yutong = 2;
    public static int Type_Luo = 3;

    private static List<Song> dataList = new ArrayList<>();
    public static ArrayList<ViewModel> testlist = new ArrayList<>();
    private static ArrayList<meinv> list = new ArrayList<>();

    public static List<Song> getLocalMusic(int type) {
        dataList.clear();
        if (Type_Like == type) {

        } else if (Type_Yutong == type) {

        } else if (Type_Luo == type) {

        }
        return dataList;

    }

    public static ArrayList<ViewModel> getTestlist() {
        testlist.clear();
        ViewModel model1 = new ViewModel();
        model1.type = "A";
        ViewModel model2 = new ViewModel();
        model2.type = "B";
        testlist.add(model1);
        testlist.add(model2);

        ViewModel model3 = new ViewModel();
        TestData data = new TestData();
        data.left_img = R.drawable.ol1;
        data.center_img = R.drawable.ol2;
        data.right_img = R.drawable.ol3;
        data.left_txt = "我想要一生,两人,三餐,四季,细水长流";
        data.center_txt = "昼短苦夜长,何不秉烛游";
        data.right_txt = "如何舒服的躺在沙发上";
        model3.type = "C";
        model3.content = data;

        ViewModel model4 = new ViewModel();
        TestData data4 = new TestData();
        data4.left_img = R.drawable.ol5;
        data4.center_img = R.drawable.ol6;
        data4.right_img = R.drawable.ol7;
        data4.left_txt = "我想要一生,两人,三餐,四季,细水长流";
        data4.center_txt = "昼短苦夜长,何不秉烛游";
        data4.right_txt = "如何舒服的躺在沙发上";
        model4.type = "C";
        model4.content = data4;

        ViewModel model5 = new ViewModel();
        TestData data5 = new TestData();
        data5.left_img = R.drawable.ol8;
        data5.center_img = R.drawable.ol9;
        data5.right_img = R.drawable.ol10;
        data5.left_txt = "我想要一生,两人,三餐,四季,细水长流";
        data5.center_txt = "昼短苦夜长,何不秉烛游";
        data5.right_txt = "如何舒服的躺在沙发上";
        model5.type = "C";
        model5.content = data5;

        ViewModel model6 = new ViewModel();
        TestData data6 = new TestData();
        data6.left_img = R.drawable.ol11;
        data6.center_img = R.drawable.ol2;
        data6.right_img = R.drawable.ol13;
        data6.left_txt = "我想要一生,两人,三餐,四季,细水长流";
        data6.center_txt = "昼短苦夜长,何不秉烛游";
        data6.right_txt = "如何舒服的躺在沙发上";
        model6.type = "C";
        model6.content = data6;

        ViewModel model7 = new ViewModel();
        TestData data7 = new TestData();
        data7.left_img = R.drawable.ol14;
        data7.center_img = R.drawable.ol5;
        data7.right_img = R.drawable.ol16;
        data7.left_txt = "我想要一生,两人,三餐,四季,细水长流";
        data7.center_txt = "昼短苦夜长,何不秉烛游";
        data7.right_txt = "如何舒服的躺在沙发上";
        model7.type = "C";
        model7.content = data7;

        ViewModel model8 = new ViewModel();
        TestData data8 = new TestData();
        data8.left_img = R.drawable.ol17;
        data8.center_img = R.drawable.ol8;
        data8.right_img = R.drawable.ol19;
        data8.left_txt = "我想要一生,两人,三餐,四季,细水长流";
        data8.center_txt = "昼短苦夜长,何不秉烛游";
        data8.right_txt = "如何舒服的躺在沙发上";
        model8.type = "C";
        model8.content = data8;

        ViewModel model9 = new ViewModel();
        TestData data9 = new TestData();
        data9.left_img = R.drawable.ol20;
        data9.center_img = R.drawable.ol21;
        data9.right_img = R.drawable.ol22;
        data9.left_txt = "我想要一生,两人,三餐,四季,细水长流";
        data9.center_txt = "昼短苦夜长,何不秉烛游";
        data9.right_txt = "如何舒服的躺在沙发上";
        model9.type = "C";
        model9.content = data9;

        for (int i = 0; i < 4; i++) {
            testlist.add(model3);
            testlist.add(model4);
            testlist.add(model5);
            testlist.add(model6);
            testlist.add(model7);
            testlist.add(model8);
            testlist.add(model9);
        }

        return testlist;

    }


    public static ArrayList<meinv> getMeizi() {

        meinv meinv = new meinv(R.drawable.ol1, "小姐姐");
        list.add(meinv);
        meinv meinv2 = new meinv(R.drawable.ol2, "萝莉");
        list.add(meinv2);
        meinv meinv3 = new meinv(R.drawable.ol3, "御姐");
        list.add(meinv3);
        meinv meinv4 = new meinv(R.drawable.ol4, "萌妹子");
        list.add(meinv4);
        meinv meinv5 = new meinv(R.drawable.ol5, "小姐姐");
        list.add(meinv5);
        meinv meinv6 = new meinv(R.drawable.ol6, "小姐姐");
        list.add(meinv6);
        meinv meinv7 = new meinv(R.drawable.ol7, "小姐姐");
        list.add(meinv7);
        meinv meinv8 = new meinv(R.drawable.ol8, "萝莉");
        list.add(meinv8);
        meinv meinv9 = new meinv(R.drawable.ol9, "御姐");
        list.add(meinv9);
        meinv meinv10 = new meinv(R.drawable.ol10, "萌妹子");
        list.add(meinv10);
        meinv meinv11 = new meinv(R.drawable.ol11, "小姐姐");
        list.add(meinv11);
        meinv meinv12 = new meinv(R.drawable.ol12, "小姐姐");
        list.add(meinv12);
        meinv meinv13 = new meinv(R.drawable.ol13, "小姐姐");
        list.add(meinv13);
        meinv meinv14 = new meinv(R.drawable.ol14, "萝莉");
        list.add(meinv14);
        meinv meinv15 = new meinv(R.drawable.ol15, "御姐");
        list.add(meinv15);
        meinv meinv16 = new meinv(R.drawable.ol16, "萌妹子");
        list.add(meinv16);
        meinv meinv17 = new meinv(R.drawable.ol17, "小姐姐");
        list.add(meinv17);
        meinv meinv18 = new meinv(R.drawable.ol18, "小姐姐");
        list.add(meinv18);
        meinv meinv19 = new meinv(R.drawable.ol19, "小姐姐");
        list.add(meinv19);
        meinv meinv20 = new meinv(R.drawable.ol20, "萝莉");
        list.add(meinv20);
        meinv meinv21 = new meinv(R.drawable.ol21, "御姐");
        list.add(meinv21);
        meinv meinv22 = new meinv(R.drawable.ol22, "萌妹子");
        list.add(meinv22);
        meinv meinv23 = new meinv(R.drawable.ol23, "小姐姐");
        list.add(meinv23);
        meinv meinv24 = new meinv(R.drawable.ol24, "小姐姐");
        list.add(meinv24);
        meinv meinv25 = new meinv(R.drawable.ol25, "小姐姐");
        list.add(meinv25);
        meinv meinv26 = new meinv(R.drawable.ol26, "萝莉");
        list.add(meinv26);
        meinv meinv27 = new meinv(R.drawable.ol27, "御姐");
        list.add(meinv27);
        meinv meinv28 = new meinv(R.drawable.ol28, "萌妹子");
        list.add(meinv28);
        meinv meinv29 = new meinv(R.drawable.ol29, "小姐姐");
        list.add(meinv28);
        meinv meinv30 = new meinv(R.drawable.ol30, "小姐姐");
        list.add(meinv30);
        meinv meinv31 = new meinv(R.drawable.ol31, "小姐姐");
        list.add(meinv31);
        meinv meinv32 = new meinv(R.drawable.ol32, "萝莉");
        list.add(meinv32);
        meinv meinv33 = new meinv(R.drawable.ol33, "御姐");
        list.add(meinv33);
        meinv meinv34 = new meinv(R.drawable.ol34, "萌妹子");
        list.add(meinv34);
        meinv meinv35 = new meinv(R.drawable.ol35, "小姐姐");
        list.add(meinv35);
        meinv meinv36 = new meinv(R.drawable.ol36, "小姐姐");
        list.add(meinv36);
        meinv meinv37 = new meinv(R.drawable.ol37, "小姐姐");
        list.add(meinv37);
        meinv meinv38 = new meinv(R.drawable.ol38, "萝莉");
        list.add(meinv38);
        meinv meinv39 = new meinv(R.drawable.ol40, "御姐");
        list.add(meinv39);
        meinv meinv40 = new meinv(R.drawable.ol41, "萌妹子");
        list.add(meinv40);
        meinv meinv41 = new meinv(R.drawable.ol42, "小姐姐");
        list.add(meinv41);
        meinv meinv42 = new meinv(R.drawable.ol43, "小姐姐");
        list.add(meinv42);
        meinv meinv43 = new meinv(R.drawable.ol44, "小姐姐");
        list.add(meinv43);
        meinv meinv44 = new meinv(R.drawable.ol45, "萝莉");
        list.add(meinv44);
        meinv meinv45 = new meinv(R.drawable.ol49, "御姐");
        list.add(meinv45);
        meinv meinv46 = new meinv(R.drawable.ol46, "萌妹子");
        list.add(meinv46);
        meinv meinv47 = new meinv(R.drawable.ol47, "小姐姐");
        list.add(meinv47);
        meinv meinv48 = new meinv(R.drawable.ol48, "小姐姐");
        list.add(meinv48);
        meinv meinv49 = new meinv(R.drawable.ol50, "小姐姐");
        list.add(meinv49);
        meinv meinv50 = new meinv(R.drawable.ol51, "萝莉");
        list.add(meinv50);
        meinv meinv51 = new meinv(R.drawable.ol52, "御姐");
        list.add(meinv51);
        meinv meinv52 = new meinv(R.drawable.ol53, "萌妹子");
        list.add(meinv52);
        meinv meinv53 = new meinv(R.drawable.ol54, "小姐姐");
        list.add(meinv53);
        meinv meinv54 = new meinv(R.drawable.ol55, "小姐姐");
        list.add(meinv54);
        meinv meinv55 = new meinv(R.drawable.ol56, "小姐姐");
        list.add(meinv55);
        meinv meinv56 = new meinv(R.drawable.ol57, "萝莉");
        list.add(meinv56);
        meinv meinv57 = new meinv(R.drawable.ol39, "萝莉");
        list.add(meinv57);

        return list;
    }


}

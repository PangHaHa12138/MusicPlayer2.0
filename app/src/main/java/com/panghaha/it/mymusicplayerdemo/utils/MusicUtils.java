package com.panghaha.it.mymusicplayerdemo.utils;

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

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.panghaha.it.mymusicplayerdemo.R;
import com.panghaha.it.mymusicplayerdemo.model.Song;

import java.util.ArrayList;
import java.util.Random;

/**
 * 音乐工具类,扫描系统里面的音频文件，返回一个list集合
 */
public class MusicUtils {

    public static ArrayList<Song> getMusicData(Context context) {
        ArrayList<Song> list = new ArrayList<>();
        int[] pan = new int[]{
                R.drawable.pan1, R.drawable.pan2, R.drawable.mmpp, R.drawable.pan3, R.drawable.pan4,
                R.drawable.pan5, R.drawable.pan6, R.drawable.pan7, R.drawable.pan8, R.drawable.pan9,
                R.drawable.pan10, R.drawable.pan11, R.drawable.pan12, R.drawable.pan14, R.drawable.pan15,
                R.drawable.pan16, R.drawable.pan17, R.drawable.pan19, R.drawable.pan21, R.drawable.pan22,
                R.drawable.pan23, R.drawable.pan24, R.drawable.pan25, R.drawable.pan26, R.drawable.pan27,
                R.drawable.pan28, R.drawable.pan29, R.drawable.pan31, R.drawable.pan32, R.drawable.pan33,
                R.drawable.pan34, R.drawable.pan35, R.drawable.pan36, R.drawable.pan37, R.drawable.pan38,
                R.drawable.pan38, R.drawable.pan40, R.drawable.pan41, R.drawable.pan42, R.drawable.pan43,
                R.drawable.pan44 };


        // 媒体库查询语句（写一个工具类MusicUtils）
        try {
            Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    null, null, null, MediaStore.Audio.AudioColumns.IS_MUSIC);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    Song song = new Song();
                    song.song = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));
                    song.singer = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
                    song.path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                    song.duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
                    song.size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE));
                    song.image = pan[new Random().nextInt(pan.length)];
//                    song.image = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID));
                    if (song.size > 1000 * 800) {
                        // 注释部分是切割标题，分离出歌曲名和歌手 （本地媒体库读取的歌曲信息不规范）
                        if (song.song.contains("-")) {
                            String[] str = song.song.split("-");
                            song.singer = str[0];
                            song.song = str[1];
                        }
                        list.add(song);
                    }
                }
                // 释放资源
                cursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 定义一个方法用来格式化获取到的时间
     */
    public static String formatTime(int time) {
        if (time / 1000 % 60 < 10) {
            return time / 1000 / 60 + ":0" + time / 1000 % 60;

        } else {
            return time / 1000 / 60 + ":" + time / 1000 % 60;
        }

    }

    public static String formatTime2(int duration) {
        int min = duration / 1000 / 60;
        int sec = duration / 1000 % 60;

        return (min < 10 ? "0" + min : min + "") + ":" + (sec < 10 ? "0" + sec : sec + "");
    }
}

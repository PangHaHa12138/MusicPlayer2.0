package com.panghaha.it.mymusicplayerdemo.model;

import java.io.Serializable;

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
public class Song implements Serializable {


    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Song(){

    }

    public Song(String singer, String song, String path, int path_local, int duration, long size, int image) {
        this.singer = singer;
        this.song = song;
        this.path = path;
        this.path_local = path_local;
        this.duration = duration;
        this.size = size;
        this.image = image;
    }

    public Song(int path_local,int image, String song, String singer) {
        this.path_local = path_local;
        this.image = image;
        this.song = song;
        this.singer = singer;
    }

    /** 歌手 */
    public String singer;
    /** 歌曲名 */
    public String song;
    /**歌曲的地址 */
    public String path;
    /**本地歌曲地址*/
    public int path_local;
    /**歌曲长度 */
    public int duration;
    /**歌曲的大小 */
    public long size;
    /**歌曲封面*/
    public int image;
}

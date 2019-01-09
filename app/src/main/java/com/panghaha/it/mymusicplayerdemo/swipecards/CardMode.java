package com.panghaha.it.mymusicplayerdemo.swipecards;

import java.util.List;

/**
 * Created by Shall on 2015-06-23.
 */
public class CardMode {
    private String name;
    private int year;
    private List<Integer> images;

    public CardMode(String name, int year, List<Integer> images) {
        this.name = name;
        this.year = year;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setImages(List<Integer> images) {
        this.images = images;
    }

    public List<Integer> getImages() {
        return images;
    }
}

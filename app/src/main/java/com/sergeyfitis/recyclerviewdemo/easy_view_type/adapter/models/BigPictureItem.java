package com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.models;

import com.sergeyfitis.recyclerviewdemo.easy_animations.ColorItem;

/**
 * Created by sergeyfitis on 2/13/17.
 */

public class BigPictureItem extends ColorItem {
    private String title;
    private String desc;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + desc.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "BigPictureItem{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

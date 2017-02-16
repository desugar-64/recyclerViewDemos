package com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.models;

import android.support.annotation.NonNull;

import com.sergeyfitis.recyclerviewdemo.R;
import com.sergeyfitis.recyclerviewdemo.easy_animations.ColorItem;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.ViewItem;

import java.util.List;

/**
 * Created by sergeyfitis on 2/13/17.
 */

public class HorizontalViewItem implements ViewItem {

    private String text;

    @NonNull
    private final List<ColorItem> items;

    public HorizontalViewItem(String text, @NonNull List<ColorItem> items) {
        this.text = text;
        this.items = items;
    }

    public String getText() {
        return text;
    }

    @NonNull
    public List<ColorItem> getItems() {
        return items;
    }

    @Override
    public long distinctId() {
        return text.hashCode() + items.size();
    }

    @Override
    public int viewType() {
        return R.layout.horizontall_item_layout;
    }
}

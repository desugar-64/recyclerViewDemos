package com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.models;

import android.support.annotation.NonNull;

import com.sergeyfitis.recyclerviewdemo.R;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.ViewItem;

/**
 * Created by sergeyfitis on 2/13/17.
 */

public class BigPictureViewItem implements ViewItem {
    @NonNull
    private final BigPictureItem item;

    public BigPictureViewItem(@NonNull BigPictureItem item) {
        this.item = item;
    }

    @NonNull
    public BigPictureItem getItem() {
        return item;
    }

    @Override
    public int distinctId() {
        return item.hashCode();
    }

    @Override
    public int viewType() {
        return R.layout.big_picture_item_layout;
    }
}

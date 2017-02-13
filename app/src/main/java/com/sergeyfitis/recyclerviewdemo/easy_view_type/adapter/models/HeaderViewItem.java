package com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.models;

import android.support.annotation.NonNull;

import com.sergeyfitis.recyclerviewdemo.R;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.ViewItem;

/**
 * Created by sergeyfitis on 2/13/17.
 */

public class HeaderViewItem implements ViewItem {

    @NonNull
    private final String headerText;

    public HeaderViewItem(@NonNull String headerText) {
        this.headerText = headerText;
    }

    @NonNull
    public String getHeaderText() {
        return headerText;
    }

    @Override
    public int distinctId() {
        return headerText.hashCode();
    }

    @Override
    public int viewType() {
        return R.layout.header_item_layout;
    }
}

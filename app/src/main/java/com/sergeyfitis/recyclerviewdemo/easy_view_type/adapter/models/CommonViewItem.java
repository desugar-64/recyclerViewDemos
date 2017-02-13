package com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.models;

import android.support.annotation.NonNull;

import com.sergeyfitis.recyclerviewdemo.R;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.ViewItem;
import com.sergeyfitis.recyclerviewdemo.layout_performance.CommonItem;

/**
 * Created by sergeyfitis on 2/10/17.
 */

public class CommonViewItem implements ViewItem {

    @NonNull
    private final CommonItem commonItem;

    public CommonViewItem(@NonNull CommonItem commonItem) {
        this.commonItem = commonItem;
    }

    @NonNull
    public CommonItem getCommonItem() {
        return commonItem;
    }

    @Override
    public int distinctId() {
        return commonItem.hashCode();
    }

    @Override
    public int viewType() {
        return R.layout.common_item_layout;
    }
}

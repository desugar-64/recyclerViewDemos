package com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.DelegatedAdapter;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.ViewItem;

/**
 * Created by sergeyfitis on 2/13/17.
 */

public class ProgressItemAdapter implements DelegatedAdapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, ViewItem viewItem) {

    }
}

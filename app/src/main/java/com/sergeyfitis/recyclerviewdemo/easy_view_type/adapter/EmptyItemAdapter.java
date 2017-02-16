package com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sergeyfitis.recyclerviewdemo.R;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.DelegateAdapter;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.ViewItem;

/**
 * Created by sergeyfitis on 2/13/17.
 */

class EmptyItemAdapter implements DelegateAdapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new EmptyViewHolder(inflater.inflate(R.layout.empty_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, ViewItem viewItem) {

    }

    private static class EmptyViewHolder extends RecyclerView.ViewHolder {

        EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }
}

package com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by sergeyfitis on 2/10/17.
 */

public interface DelegatedAdapter {

    RecyclerView.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent);
    void onBindViewHolder(RecyclerView.ViewHolder holder, ViewItem viewItem);

}

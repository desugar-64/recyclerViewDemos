package com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sergeyfitis.recyclerviewdemo.R;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.DelegateAdapter;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.ViewItem;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.models.HeaderViewItem;

/**
 * Created by sergeyfitis on 2/13/17.
 */

public class HeaderItemsAdapter implements DelegateAdapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new HeaderViewHolder(inflater.inflate(R.layout.header_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, ViewItem viewItem) {
        HeaderViewHolder vh = (HeaderViewHolder) holder;
        vh.bind((HeaderViewItem) viewItem);
    }

    private static class HeaderViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private HeaderViewItem item;

        HeaderViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView;
        }

        private void bind(HeaderViewItem item) {
            this.item = item;
            tvTitle.setText(item.getHeaderText());
        }
    }
}

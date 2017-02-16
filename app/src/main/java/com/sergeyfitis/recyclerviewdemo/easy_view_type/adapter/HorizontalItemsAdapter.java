package com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sergeyfitis.recyclerviewdemo.R;
import com.sergeyfitis.recyclerviewdemo.easy_animations.ColorItem;
import com.sergeyfitis.recyclerviewdemo.easy_animations.ColorsAdapter;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.DelegateAdapter;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.ViewItem;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.models.HorizontalViewItem;

import java.util.List;

/**
 * Created by sergeyfitis on 2/13/17.
 */

class HorizontalItemsAdapter implements DelegateAdapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new HorizontalViewHolder(inflater.inflate(R.layout.horizontall_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, ViewItem viewItem) {
        final HorizontalViewHolder vh = (HorizontalViewHolder) holder;
        vh.bind((HorizontalViewItem) viewItem);
    }

    private static class HorizontalViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;
        private TextView tvHorizontalHeader;


        HorizontalViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.rvHorizontal);
            recyclerView.setHasFixedSize(true);
            final LinearLayoutManager layoutManager =
                    new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);
            layoutManager.setItemPrefetchEnabled(true);
            layoutManager.setInitialPrefetchItemCount(4);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);

            tvHorizontalHeader = (TextView) itemView.findViewById(R.id.tvHorizontalHeader);
        }

        private void bind(HorizontalViewItem item) {
            tvHorizontalHeader.setText(item.getText());

            final List<ColorItem> items = item.getItems();
            if (recyclerView.getAdapter() == null) {
                recyclerView.setAdapter(new ColorsAdapter(items, null));
            } else {
                ((ColorsAdapter) recyclerView.getAdapter()).updateAdapter(items);
            }
        }
    }
}

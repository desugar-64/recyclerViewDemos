package com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter;

import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sergeyfitis.recyclerviewdemo.R;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.DelegateAdapter;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.ViewItem;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.models.CommonViewItem;

/**
 * Created by sergeyfitis on 2/13/17.
 */

public class CommonItemsAdapter implements DelegateAdapter {


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new CommonViewHolder(inflater.inflate(R.layout.common_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, ViewItem viewItem) {
        CommonViewHolder vh = (CommonViewHolder) holder;
        vh.bind((CommonViewItem) viewItem);
    }

    private static class CommonViewHolder extends RecyclerView.ViewHolder {
        private CommonViewItem item;
        private ImageView imageView;
        private TextView tvTitle;
        private TextView tvBody;

        CommonViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.ivAvatar);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvBody = (TextView) itemView.findViewById(R.id.tvBody);

        }

        private void bind(CommonViewItem item) {
            this.item = item;
            tvTitle.setText(item.getCommonItem().getTitle());
            tvBody.setText(item.getCommonItem().getBody());
            imageView.setColorFilter(item.getCommonItem().getColor(), PorterDuff.Mode.SRC_ATOP);

        }
    }
}

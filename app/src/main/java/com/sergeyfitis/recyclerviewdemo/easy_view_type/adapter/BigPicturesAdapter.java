package com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter;

import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sergeyfitis.recyclerviewdemo.R;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.DelegatedAdapter;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.ViewItem;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.models.BigPictureViewItem;

/**
 * Created by sergeyfitis on 2/13/17.
 */

class BigPicturesAdapter implements DelegatedAdapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        return new PictureViewHolder(inflater.inflate(R.layout.big_picture_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, ViewItem viewItem) {
        final PictureViewHolder vh = (PictureViewHolder) holder;
        vh.bind((BigPictureViewItem) viewItem);
    }

    private static class PictureViewHolder extends RecyclerView.ViewHolder {
        private BigPictureViewItem item;
        private ImageView imageView;
        private TextView tvHeader;
        private TextView tvDesc;

        PictureViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.ivBigPicture);
            tvDesc = (TextView) itemView.findViewById(R.id.tvBigPictureHeader);
            tvHeader = (TextView) itemView.findViewById(R.id.tvBigPictureDesc);
        }

        private void bind(BigPictureViewItem item) {
            this.item = item;

            tvHeader.setText(item.getItem().getTitle());
            tvDesc.setText(item.getItem().getDesc());
            imageView.setImageDrawable(new ColorDrawable(item.getItem().getColor()));

        }
    }
}

package com.sergeyfitis.recyclerviewdemo.easy_animations;

import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sergeyfitis.recyclerviewdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergeyfitis on 19.12.16.
 */

public class ColorsAdapter extends RecyclerView.Adapter<ColorsAdapter.ColorViewHolder> {
    private LayoutInflater inflater;
    private List<ColorItem> items = new ArrayList<>();
    private final ItemClickListener clickListener;

    public ColorsAdapter(List<ColorItem> items, ItemClickListener clickListener) {
        updateAdapter(items);
        this.clickListener = clickListener;
        setHasStableIds(true);
    }

    public void updateAdapter(@Nullable List<ColorItem> colorItems) {
        items.clear();
        if (colorItems != null) {
            items.addAll(colorItems);
        }


        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getColor();
    }

    @Override
    public ColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        return ColorViewHolder.create(inflater, parent, clickListener);
    }

    @Override
    public void onBindViewHolder(ColorViewHolder holder, int position) {
        ColorItem item = items.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ColorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private final ItemClickListener clickListener;
        private ColorItem item;

        static ColorViewHolder create(LayoutInflater inflater, ViewGroup parent, ItemClickListener clickListener) {
            return new ColorViewHolder(inflater.inflate(R.layout.color_item_layout, parent, false), clickListener);
        }


        ColorViewHolder(View itemView, ItemClickListener clickListener) {
            super(itemView);
            this.clickListener = clickListener;
            imageView = (ImageView) itemView.findViewById(R.id.ivColor);
            itemView.setOnClickListener(this);
        }

        void bind(ColorItem item) {
            this.item = item;
            imageView.setImageDrawable(new ColorDrawable(item.getColor()));
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onItemClick(item);
            }
        }
    }

    interface ItemClickListener {
        void onItemClick(ColorItem item);
    }
}

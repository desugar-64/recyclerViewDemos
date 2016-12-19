package com.sergeyfitis.recyclerviewdemo;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by sergeyfitis on 19.12.16.
 */

class ColorsAdapter extends RecyclerView.Adapter<ColorsAdapter.ColorViewHolder> {
    private LayoutInflater inflater;
    private final List<ColorItem> items;
    private final ItemClickListener clickListener;

    ColorsAdapter(List<ColorItem> items, ItemClickListener clickListener) {
        this.items = items;
        this.clickListener = clickListener;
        setHasStableIds(true);
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
            imageView = (ImageView) itemView.findViewById(R.id.ivColor);
            this.clickListener = clickListener;
            itemView.setOnClickListener(this);
        }

        void bind(ColorItem item) {
            this.item = item;
            imageView.setImageDrawable(new ColorDrawable(item.getColor()));
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(item, itemView);
        }
    }

    public interface ItemClickListener {
        void onItemClick(ColorItem item, View child);
    }
}

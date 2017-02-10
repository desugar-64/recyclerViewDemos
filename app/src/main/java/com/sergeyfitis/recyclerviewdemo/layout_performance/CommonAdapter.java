package com.sergeyfitis.recyclerviewdemo.layout_performance;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sergeyfitis.recyclerviewdemo.R;

import java.util.List;

/**
 * Created by sergeyfitis on 03.01.17.
 */

public class CommonAdapter extends RecyclerView.Adapter<CommonAdapter.CommonViewHolder> {

    private LayoutInflater inflater;
    private List<CommonItem> items;

    public CommonAdapter(List<CommonItem> items) {
        updateItems(items);
        setHasStableIds(true);
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        return CommonViewHolder.create(inflater, parent);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).hashCode();
    }

    void updateItems(List<CommonItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    void insert(CommonItem item) {
        if (items != null) {
            items.add(0, item);
            notifyItemInserted(0);
        }
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    static class CommonViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView tvTitle;
        private TextView tvBody;

        public static CommonViewHolder create(LayoutInflater inflater, ViewGroup viewGroup) {
            return new CommonViewHolder(inflater.inflate(R.layout.common_item_layout, viewGroup, false));
        }

        private CommonViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.ivAvatar);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvBody = (TextView) itemView.findViewById(R.id.tvBody);
        }

        void bind(CommonItem item) {
            tvTitle.setText(item.getTitle());
            tvBody.setText(item.getBody());
            imageView.setImageTintList(ColorStateList.valueOf(item.getColor()));
            imageView.setImageTintMode(PorterDuff.Mode.DST_OVER);
        }
    }
}

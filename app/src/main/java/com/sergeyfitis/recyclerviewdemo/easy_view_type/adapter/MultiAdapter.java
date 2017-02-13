package com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sergeyfitis.recyclerviewdemo.R;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.DelegatedAdapter;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.ViewItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergeyfitis on 2/13/17.
 */

public class MultiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final SparseArray<DelegatedAdapter> adapters = new SparseArray<>();

    private final List<ViewItem> items = new ArrayList<>();

    private final ViewItem emptyItem = new ViewItem() {
        @Override
        public int distinctId() {
            return viewType();
        }

        @Override
        public int viewType() {
            return R.layout.empty_item_layout;
        }
    };

    private final ViewItem progressItem = new ViewItem() {
        @Override
        public int distinctId() {
            return viewType();
        }

        @Override
        public int viewType() {
            return R.layout.loading_item_layout;
        }
    };

    public MultiAdapter() {
        adapters.put(R.layout.header_item_layout, new HeaderItemsAdapter());
        adapters.put(R.layout.common_item_layout, new CommonItemsAdapter());
        adapters.put(R.layout.big_picture_item_layout, new BigPicturesAdapter());
        adapters.put(R.layout.horizontall_item_layout, new HorizontalItemsAdapter());
        adapters.put(R.layout.loading_item_layout, new ProgressItemAdapter());
        adapters.put(R.layout.empty_item_layout, new EmptyItemAdapter());

        // Add default item
        items.add(progressItem);

        setHasStableIds(true);
    }

    public void showProgressView() {
        items.clear();
        items.add(progressItem);
        notifyDataSetChanged();
    }

    public void updateAdapter(@Nullable List<ViewItem> viewItems) {
        items.clear();
        if (viewItems != null) {
            items.addAll(viewItems);
        }

        if (items.isEmpty()) {
            items.add(emptyItem);
        }
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).distinctId();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).viewType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return adapters.get(viewType)
                .onCreateViewHolder(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        adapters.get(getItemViewType(position))
                .onBindViewHolder(holder, items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

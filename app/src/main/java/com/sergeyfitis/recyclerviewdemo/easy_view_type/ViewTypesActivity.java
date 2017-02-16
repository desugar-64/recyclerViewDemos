package com.sergeyfitis.recyclerviewdemo.easy_view_type;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.sergeyfitis.recyclerviewdemo.R;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.MultiAdapter;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.ViewItem;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.decorator.MultiDecorator;

import java.util.Collections;
import java.util.List;

public class ViewTypesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    public static void start(@NonNull Context context) {
        context.startActivity(new Intent(context, ViewTypesActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_types);

        recyclerView = (RecyclerView) findViewById(R.id.rvTypes);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setClipChildren(false);
        recyclerView.setClipToPadding(false);

        final MultiAdapter multiAdapter = new MultiAdapter();
        recyclerView.setAdapter(multiAdapter);

        final Drawable generalDivider = ContextCompat.getDrawable(this, R.drawable.general_divider);
        final Drawable headerDrawable = ContextCompat.getDrawable(this, R.drawable.header_divider);

        recyclerView.addItemDecoration(new MultiDecorator(generalDivider, headerDrawable));

        getItems(multiAdapter);

        final Button btnClear = (Button) findViewById(R.id.btnClear);
        final Button btnReload = (Button) findViewById(R.id.btnReload);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiAdapter.updateAdapter(Collections.<ViewItem>emptyList());
            }
        });

        btnReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getItems(multiAdapter);
            }
        });
    }

    private void getItems(final MultiAdapter multiAdapter) {
        multiAdapter.showProgressView();
        ItemsHelper.getItems(new ItemsHelper.Callback() {
            @Override
            public void onItemsReady(@Nullable final List<ViewItem> items) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        multiAdapter.updateAdapter(items);

                    }
                });
            }
        });
    }
}

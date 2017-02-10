package com.sergeyfitis.recyclerviewdemo.easy_animations;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sergeyfitis.recyclerviewdemo.utils.GridSpacingItemDecoration;
import com.sergeyfitis.recyclerviewdemo.R;
import com.sergeyfitis.recyclerviewdemo.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static android.text.Spanned.SPAN_EXCLUSIVE_INCLUSIVE;

public class EasyAnimationsActivity extends AppCompatActivity {

    private final List<ColorItem> items = new ArrayList<>();
    private RecyclerView recyclerView;

    public static void start(Context ctx) {
        ctx.startActivity(new Intent(ctx, EasyAnimationsActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_animations);


        recyclerView = (RecyclerView) findViewById(R.id.rvColors);
        Button add = (Button) findViewById(R.id.btnInsert);
        Button shuffle = (Button) findViewById(R.id.btnShuffle);
        Button delete = (Button) findViewById(R.id.btnDelete);
        final View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnInsert:
                        insertOneItem();
                        break;
                    case R.id.btnShuffle:
                        shuffleItems();
                        break;
                    case R.id.btnDelete:
                        deleteItem();
                        break;
                }
            }
        };
        add.setOnClickListener(onClickListener);
        shuffle.setOnClickListener(onClickListener);
        delete.setOnClickListener(onClickListener);

        createItems();

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3) {
            @Override
            public boolean supportsPredictiveItemAnimations() {
                return true;
            }
        };
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator() {
            @Override
            public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder viewHolder) {
                return true;
            }
        });
        int spacing = getResources().getDimensionPixelSize(R.dimen.activity_vertical_margin);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(gridLayoutManager.getSpanCount(), spacing, true));

        ColorsAdapter adapter = new ColorsAdapter(items, new ColorsAdapter.ItemClickListener() {
            @Override
            public void onItemClick(ColorItem item) {
                final String color = "color";
                SpannableString string = new SpannableString(color);
                string.setSpan(new ForegroundColorSpan(item.getColor()), 0, color.length(), SPAN_EXCLUSIVE_INCLUSIVE);
                Toast.makeText(EasyAnimationsActivity.this, string, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);
    }

    private void createItems() {
        items.clear();
        int[] colorsRes = getResources().getIntArray(R.array.colors);
        for (int colorsRe : colorsRes) {
            ColorItem colorItem = new ColorItem();
            colorItem.setColor(colorsRe);
            items.add(colorItem);
        }
    }

    private void deleteItem() {
        if (!items.isEmpty()) {
            items.remove(0);
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    private void shuffleItems() {
        Collections.shuffle(items);
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    private void insertOneItem() {
        items.add(0, createRandomItem());
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    private ColorItem createRandomItem() {
        ColorItem colorItem = new ColorItem();
        colorItem.setColor(Utils.randomColor(TimeUnit.NANOSECONDS.toMillis(System.nanoTime())));
        return colorItem;
    }
}

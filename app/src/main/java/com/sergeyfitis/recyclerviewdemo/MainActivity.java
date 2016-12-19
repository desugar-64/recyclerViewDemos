package com.sergeyfitis.recyclerviewdemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final List<ColorItem> items = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setItemAnimator(new DefaultItemAnimator() {
            @Override
            public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder viewHolder) {
                return true;
            }
        });

        ColorsAdapter adapter = new ColorsAdapter(items, new ColorsAdapter.ItemClickListener() {
            @Override
            public void onItemClick(ColorItem item, View view) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra(ColorItem.class.getSimpleName(), item);
                ActivityOptions optionsCompat = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, view, view.getTransitionName());
                startActivity(intent, optionsCompat.toBundle());
            }
        });

        recyclerView.setAdapter(adapter);
    }

    private void createItems() {
        items.clear();
        int[] colorsRes = getResources().getIntArray(R.array.colors);
        for (int i = 0; i < colorsRes.length; i++) {
            ColorItem colorItem = new ColorItem();
            colorItem.setColor(colorsRes[i]);
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
        Random rnd = new Random();
        rnd.setSeed(System.nanoTime() / 1000L);
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        colorItem.setColor(color);
        return colorItem;
    }
}

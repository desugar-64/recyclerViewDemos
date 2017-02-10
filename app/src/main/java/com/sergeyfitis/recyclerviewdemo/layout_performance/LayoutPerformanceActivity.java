package com.sergeyfitis.recyclerviewdemo.layout_performance;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.sergeyfitis.recyclerviewdemo.R;
import com.sergeyfitis.recyclerviewdemo.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LayoutPerformanceActivity extends AppCompatActivity {

    private static final String TITLE = "Title ";

    public static void start(Context ctx) {
        ctx.startActivity(new Intent(ctx, LayoutPerformanceActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_performance);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvPerformance);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        Button btnCreate = (Button) findViewById(R.id.btnCreate);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        recyclerView.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean supportsPredictiveItemAnimations() {
                return true;
            }
        });
        final View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnCreate:
                        CommonAdapter adapter = new CommonAdapter(createItems(20));
                        recyclerView.setAdapter(adapter);
                        break;
                    case R.id.btnAdd:
                        ((CommonAdapter) recyclerView.getAdapter()).insert(randomItem());
                        recyclerView.getLayoutManager().scrollToPosition(0);
                        break;
                }
            }
        };
        btnAdd.setOnClickListener(onClickListener);
        btnCreate.setOnClickListener(onClickListener);
    }

    private CommonItem randomItem() {
        CommonItem item = new CommonItem();
        item.setColor(Utils.randomColor(TimeUnit.NANOSECONDS.toMillis(System.nanoTime())));
        item.setTitle(TITLE + 0);
        item.setBody(getString(R.string.long_text));
        return item;
    }

    private List<CommonItem> createItems(int count) {
        List<CommonItem> items = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            CommonItem item = new CommonItem();
            item.setColor(Utils.randomColor(TimeUnit.NANOSECONDS.toMillis(System.nanoTime())));
            item.setTitle(TITLE + i);
            item.setBody(i % 3 == 0 ? getString(R.string.long_text) : getString(R.string.short_text));
            items.add(item);
        }
        return items;
    }


}

package com.sergeyfitis.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sergeyfitis.recyclerviewdemo.easy_animations.EasyAnimationsActivity;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.ViewTypesActivity;
import com.sergeyfitis.recyclerviewdemo.layout_performance.LayoutPerformanceActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAnimations = (Button) findViewById(R.id.btnAnimations);
        Button btnLayoutPerformance = (Button) findViewById(R.id.btnLayoutPerformance);
        Button btnMultyViewType = (Button) findViewById(R.id.btnMultiViewType);

        final View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnAnimations:
                        EasyAnimationsActivity.start(MainActivity.this);
                        break;
                    case R.id.btnLayoutPerformance:
                        LayoutPerformanceActivity.start(MainActivity.this);
                        break;
                    case R.id.btnMultiViewType:
                        ViewTypesActivity.start(MainActivity.this);
                        break;
                }
            }
        };

        btnAnimations.setOnClickListener(onClickListener);
        btnLayoutPerformance.setOnClickListener(onClickListener);
        btnMultyViewType.setOnClickListener(onClickListener);

    }
}

package com.sergeyfitis.recyclerviewdemo;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionInflater;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        final ColorItem colorItem = getIntent().getParcelableExtra(ColorItem.class.getSimpleName());
        final ImageView imageView = (ImageView) findViewById(R.id.ivDetails);
        postponeEnterTransition();
        imageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                imageView.setImageBitmap(fromColor(colorItem.getColor(), imageView.getHeight(), imageView.getWidth()));
                startPostponedEnterTransition();
                return false;
            }
        });

    }

    private Bitmap fromColor(int color, int height, int width) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        bitmap.eraseColor(color);
        return bitmap;
    }
}

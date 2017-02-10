package com.sergeyfitis.recyclerviewdemo.easy_view_type;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by sergeyfitis on 2/10/17.
 */

public class AspectImageView extends AppCompatImageView {
    private static final float ASPECT_16_X_9 = 16f / 9f;
    public AspectImageView(Context context) {
        super(context);
    }

    public AspectImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AspectImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int desiredHeight = (int) (width / ASPECT_16_X_9);
        setMeasuredDimension(width, desiredHeight);
    }
}

package com.sergeyfitis.recyclerviewdemo.utils;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;

import java.util.Random;

/**
 * Created by sergeyfitis on 03.01.17.
 */

public class Utils {
    private Utils() {
    }

    public static int dp2Px(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static int randomColor(long seed) {
        Random rnd = new Random();
        rnd.setSeed(seed);
        return Color.argb(255, rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
    }
}

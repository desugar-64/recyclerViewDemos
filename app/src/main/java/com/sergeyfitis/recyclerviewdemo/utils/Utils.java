package com.sergeyfitis.recyclerviewdemo.utils;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by sergeyfitis on 03.01.17.
 */

public class Utils {
    private Utils() {
    }

    public static int randomColor(long seed) {
        Random rnd = new Random();
        rnd.setSeed(seed);
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}

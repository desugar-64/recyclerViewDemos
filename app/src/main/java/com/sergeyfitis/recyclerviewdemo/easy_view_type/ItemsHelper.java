package com.sergeyfitis.recyclerviewdemo.easy_view_type;

import android.os.Process;
import android.support.annotation.Nullable;

import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.ViewItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sergeyfitis on 2/13/17.
 */

class ItemsHelper {
    private ItemsHelper() {}

    interface Callback {
        void onItemsReady(@Nullable List<ViewItem> items);
    }

    public static void getItems(Callback callback) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                        List<ViewItem> items = new ArrayList<>();
                    }
                }
        ).start();
    }
}

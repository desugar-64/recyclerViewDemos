package com.sergeyfitis.recyclerviewdemo.easy_view_type;

import android.os.Process;
import android.os.SystemClock;
import android.support.annotation.Nullable;

import com.sergeyfitis.recyclerviewdemo.easy_animations.ColorItem;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.base.ViewItem;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.models.BigPictureItem;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.models.BigPictureViewItem;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.models.CommonViewItem;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.models.HeaderViewItem;
import com.sergeyfitis.recyclerviewdemo.easy_view_type.adapter.models.HorizontalViewItem;
import com.sergeyfitis.recyclerviewdemo.layout_performance.CommonItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.sergeyfitis.recyclerviewdemo.utils.Utils.randomColor;

/**
 * Created by sergeyfitis on 2/13/17.
 */

class ItemsHelper {
    private static final String LOREM_IPSUM = "Lorem ipsum dolor sit amet, facete denique deseruisse vis et, sed ut dolores iracundia. Te clita honestatis usu, everti copiosae vim ne.";

    private ItemsHelper() {}

    interface Callback {
        void onItemsReady(@Nullable List<ViewItem> items);
    }

    public static void getItems(final Callback callback) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);

                        SystemClock.sleep(TimeUnit.SECONDS.toMillis(2)); // emulate network

                        final List<ViewItem> items = new ArrayList<>();

                        final HeaderViewItem firstHeader = new HeaderViewItem("Header 1");

                        items.add(firstHeader);

                        for (int i = 0; i < 5; i++) {
                            final CommonItem commonItem = new CommonItem();
                            commonItem.setTitle("Common item #" + (i + 1));
                            commonItem.setBody(LOREM_IPSUM);
                            commonItem.setColor(randomColor(i));
                            final CommonViewItem item = new CommonViewItem(commonItem);
                            items.add(item);
                        }

                        final List<ColorItem> subHorizontalItems = new ArrayList<>();
                        for (int i = 0; i < 15; i++) {
                            final ColorItem colorItem = new ColorItem();
                            colorItem.setColor(randomColor(i));
                            subHorizontalItems.add(colorItem);
                        }
                        final HorizontalViewItem horizontalItem = new HorizontalViewItem("Horizontal item #1", subHorizontalItems);
                        items.add(horizontalItem);

                        final HeaderViewItem secondHeader = new HeaderViewItem("Header 2");

                        items.add(secondHeader);

                        final CommonItem commonItem = new CommonItem();
                        commonItem.setTitle("Common item #6");
                        commonItem.setBody(LOREM_IPSUM);
                        commonItem.setColor(randomColor((int) System.nanoTime()));
                        final CommonViewItem item = new CommonViewItem(commonItem);
                        items.add(item);

                        for (int i = 0; i < 3; i++) {
                            final BigPictureItem bigPictureItem = new BigPictureItem();
                            bigPictureItem.setTitle("Big picture #" + (i + 1));
                            bigPictureItem.setDesc("Big picture desc...");
                            bigPictureItem.setColor(randomColor(i));
                            final BigPictureViewItem viewItem =  new BigPictureViewItem(bigPictureItem);
                            items.add(viewItem);
                        }

                        final HeaderViewItem thirdHeader = new HeaderViewItem("Header 3");

                        items.add(thirdHeader);

                        final List<ColorItem> subHorizontalItems2 = new ArrayList<>();
                        for (int i = 15; i < 40; i++) {
                            final ColorItem colorItem = new ColorItem();
                            colorItem.setColor(randomColor(i));
                            subHorizontalItems2.add(colorItem);
                        }
                        final HorizontalViewItem horizontalItem2 = new HorizontalViewItem("Horizontal item #2", subHorizontalItems2);
                        items.add(horizontalItem2);

                        if (callback != null) {
                            callback.onItemsReady(items);
                        }

                    }
                }
        ).start();
    }

}

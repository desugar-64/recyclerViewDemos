package com.sergeyfitis.recyclerviewdemo.easy_view_type.decorator;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.sergeyfitis.recyclerviewdemo.R;
import com.sergeyfitis.recyclerviewdemo.utils.Utils;

import static com.sergeyfitis.recyclerviewdemo.R.layout.common_item_layout;
import static com.sergeyfitis.recyclerviewdemo.R.layout.empty_item_layout;
import static com.sergeyfitis.recyclerviewdemo.R.layout.header_item_layout;
import static com.sergeyfitis.recyclerviewdemo.R.layout.loading_item_layout;

/**
 * Created by sergeyfitis on 2/14/17.
 */

public class MultiDecorator extends RecyclerView.ItemDecoration {

    private final Drawable generalDivider;
    private final Drawable headerDivider;

    public MultiDecorator(Drawable generalDivider, Drawable headerDivider) {
        this.generalDivider = generalDivider;
        this.headerDivider = headerDivider;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        final int offset = generalDivider.getIntrinsicHeight() / 2;
        for (int i = 0; i < parent.getChildCount(); i++) {
            final View child = parent.getChildAt(i);
            final int adapterPosition = parent.getChildAdapterPosition(child);
            final RecyclerView.Adapter adapter = parent.getAdapter();

            if (adapterPosition != RecyclerView.NO_POSITION) {
                final int viewType = adapter.getItemViewType(adapterPosition);
                if (isAcceptableViewType(viewType)) {
                    outRect.top = offset;
                    outRect.bottom = offset;
                }
            }
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        for (int i = 0; i < parent.getChildCount(); i++) {
            final View child = parent.getChildAt(i);
            final int adapterPosition = parent.getChildAdapterPosition(child);
            if (adapterPosition != RecyclerView.NO_POSITION) {
                final RecyclerView.Adapter adapter = parent.getAdapter();
                final int viewType = adapter
                        .getItemViewType(adapterPosition);
                final int adapterItemsCount = adapter.getItemCount();

                int dividerTop;
                int dividerBottom;
                int dividerLeft;
                int dividerRight;

                final int childTop = parent.getLayoutManager().getDecoratedTop(child);
                final int childBottom = parent.getLayoutManager().getDecoratedBottom(child);

                if (viewType == header_item_layout) {

                    dividerTop = (int) (childTop + child.getTranslationY());
                    dividerBottom = (int) (childBottom + child.getTranslationY());
                    dividerLeft = child.getLeft();
                    dividerRight = child.getRight();

                    headerDivider.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom);
                    headerDivider.draw(c);
                } else {

                    final int nextItem = adapterPosition + 1;

                    if (nextItem < adapterItemsCount && isAcceptableViewType(adapter.getItemViewType(nextItem))) {

                        dividerTop = (int) (child.getBottom() + child.getTranslationY());
                        dividerBottom = (int) (dividerTop + generalDivider.getIntrinsicHeight() + child.getTranslationY());
                        dividerLeft = child.getLeft();
                        dividerRight = child.getRight();

                        if (viewType == common_item_layout && adapter.getItemViewType(nextItem) == common_item_layout) {
                            dividerLeft = Utils.dp2Px(parent.getContext(), 76);
                        }

                        generalDivider.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom);
                        generalDivider.draw(c);
                    }


                }

            }
        }
    }

    private boolean isAcceptableViewType(int viewType) {
        return viewType != header_item_layout && viewType != empty_item_layout && viewType != loading_item_layout;
    }
}

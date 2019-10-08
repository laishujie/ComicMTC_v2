package com.lai.comicmtc_v2.ui.home;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class HomeSortItemDecoration extends RecyclerView.ItemDecoration {

    private int space;

    private int headSpace;
    private int footSpace;

    public HomeSortItemDecoration(int space, int headSpace, int footSpace) {
        this.space = space / 2;
        this.headSpace = headSpace;
        this.footSpace = footSpace;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int itemPosition = parent.getChildAdapterPosition(view);
        if (itemPosition == 0) {
            outRect.left = headSpace;
            outRect.right = space;
        } else if (itemPosition == state.getItemCount() - 1) {
            outRect.left = space;
            outRect.right = footSpace;
        } else {
            outRect.left = space;
            outRect.right = space;
        }
    }

}

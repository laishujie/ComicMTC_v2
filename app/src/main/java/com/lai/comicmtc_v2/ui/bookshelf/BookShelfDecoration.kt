package com.lai.comicmtc_v2.ui.bookshelf

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lai.comicmtc_v2.utils.DecorationUtils
import com.lai.comicmtc_v2.utils.DisplayUtils

/**
 *
 * @author  Lai
 *
 * @time 2019/10/2 15:39
 * @describe describe
 *
 */
class BookShelfDecoration : RecyclerView.ItemDecoration() {

    private var topAndBottom = DisplayUtils.dp2px(15f)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val layoutManager = parent.layoutManager as GridLayoutManager?
        val itemPosition = parent.getChildAdapterPosition(view)
        layoutManager?.also {
            when {
                //如果是在左边
                DecorationUtils.isFirstColumn(3, itemPosition) -> {
                    outRect.left = DisplayUtils.dp2px(10f)
                }
                //如果是在右边
                DecorationUtils.isLastColumn(parent, itemPosition, 3) -> {
                    outRect.right = DisplayUtils.dp2px(10f)
                }
            }
        }

        if (itemPosition <= 2) {
            outRect.top = topAndBottom
            outRect.bottom = topAndBottom
        } else {
            outRect.bottom = topAndBottom
        }

    }


}
package com.lai.comicmtc_v2.ui.detail

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
class ChapterDecoration : RecyclerView.ItemDecoration() {


    private var space = DisplayUtils.dp2px(15f)


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val layoutManager = parent.layoutManager as GridLayoutManager?
        val position = parent.getChildAdapterPosition(view)
        layoutManager?.also {
            when {
                //如果是在左边
                DecorationUtils.isFirstColumn(2, position) -> {
                    outRect.left = space
                    outRect.right = space/2
                }
                //如果是在右边
                DecorationUtils.isLastColumn(parent, position, 2) -> {
                    outRect.right = space
                    outRect.left = space/2
                }
            }
        }
        outRect.top = space/2
        outRect.bottom = space/2
    }


}
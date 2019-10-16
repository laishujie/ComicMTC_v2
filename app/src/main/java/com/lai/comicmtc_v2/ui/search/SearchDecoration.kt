package com.lai.comicmtc_v2.ui.search

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lai.comicmtc_v2.utils.DisplayUtils

/**
 *
 * @author  Lai
 *
 * @time 2019/10/2 15:39
 * @describe describe
 *
 */
class SearchDecoration : RecyclerView.ItemDecoration() {

    private var topAndBottom = DisplayUtils.dp2px(5f)
    private var rAndLBottom = DisplayUtils.dp2px(5f)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.top = topAndBottom
        outRect.bottom = topAndBottom
    }


}
package com.lai.comicmtc_v2.utils

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

/**
 *
 * @author  Lai
 *
 * @time 2019/10/2 20:31
 * @describe describe
 *
 */
object DecorationUtils{
    /**
     * 是否是第一列
     *
     * @param spanCount
     * @param readPosition
     * @return
     */
     fun isFirstColumn(spanCount: Int, readPosition: Int): Boolean {
        return readPosition % spanCount == 0
    }

    /**
     * 判断是否是最后一列
     *
     * @param parent
     * @param pos
     * @param spanCount
     * @return
     */
     fun isLastColumn(parent: RecyclerView, pos: Int, spanCount: Int): Boolean {
        val layoutManager = parent.layoutManager
        if (layoutManager is GridLayoutManager) {
            // 如果是最后一列，则不需要绘制右边
            return (pos + 1) % spanCount == 0
        } else if (layoutManager is StaggeredGridLayoutManager) {
            val orientation = layoutManager
                    .orientation
            if (orientation == StaggeredGridLayoutManager.VERTICAL) {
                // 最后一列
                return (pos + 1) % spanCount == 0
            }
        }
        return false
    }
}
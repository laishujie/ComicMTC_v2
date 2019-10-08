package com.lai.comicmtc_v2.ui.home

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lai.comicmtc_v2.bean.home.HomeTypeInfo
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
class HomeDecoration(space: Int, private var headSpace: Int, private var footSpace: Int) : RecyclerView.ItemDecoration() {

    private var space: Int = 0

    private var topAndBottom = DisplayUtils.dp2px(10f)

    private var spanCount2LetAndRight = 0

    init {
        spanCount2LetAndRight = DisplayUtils.getScreenWidth() - (3* DisplayUtils.dp2px(110f))
        this.space = space / 2
    }


    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val layoutManager = parent.layoutManager as GridLayoutManager?
        val itemPosition = parent.getChildAdapterPosition(view)
        layoutManager?.also {
            val spanSize = layoutManager.spanSizeLookup.getSpanSize(itemPosition)

            if (spanSize == layoutManager.spanCount) {
                if (layoutManager.getItemViewType(view) != HomeTypeInfo.HEARD_LIST){
                    outRect.left = headSpace
                    outRect.right = footSpace
                }
            }else if(spanSize == 2){
                val infoListIndex = getListPosition(parent, view)
                when {
                    //如果是在左边
                    DecorationUtils.isFirstColumn(3, infoListIndex) -> {
                        outRect.left = DisplayUtils.dp2px(6f)
                    }
                    //如果是在右边
                    DecorationUtils.isLastColumn(parent, infoListIndex, 3) -> {
                        outRect.right = DisplayUtils.dp2px(6f)
                    }
                }
            }else if(spanSize == 3){
                val infoListIndex = getListPosition(parent, view)
                when {
                    //如果是在左边
                    DecorationUtils.isFirstColumn(2, infoListIndex) -> {
                        outRect.left = DisplayUtils.dp2px(26f)
                        outRect.right = DisplayUtils.dp2px(5f)
                    }
                    //如果是在右边
                    DecorationUtils.isLastColumn(parent, infoListIndex, 2) -> {
                        outRect.right = DisplayUtils.dp2px(26f)
                        outRect.left = DisplayUtils.dp2px(5f)
                    }
                }

            }
        }

        if (itemPosition == 0) {
            outRect.top = topAndBottom
            outRect.bottom = DisplayUtils.dp2px(12f)
        }else{
            outRect.bottom = topAndBottom
        }

    }


    /**
     * 获取view对于的坐标
     *
     * @param parent
     * @param view
     * @return
     */
    private fun getListPosition(parent: RecyclerView, view: View): Int {
        val childLayoutPosition = parent.getChildLayoutPosition(view)
        val homeAdapter = parent.adapter as HomeAdapter?
        val homeListInfo = homeAdapter!!.data[childLayoutPosition]
        return homeListInfo.listIndex
    }





}
package com.lai.comicmtc_v2.ui.home

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lai.comicmtc_v2.R
import com.lai.comicmtc_v2.bean.home.RecommendResponse
import com.lai.comicmtc_v2.utils.DisplayUtils
import com.lai.comicmtc_v2.utils.GlideUtils

/**
 *
 * @author  Lai
 *
 * @time 2019/10/1 23:30
 * @describe describe
 *
 */
class HomeListItemAdapter1(data: List<RecommendResponse.ComicListsBean.ComicsBean>) :
    BaseQuickAdapter<RecommendResponse.ComicListsBean.ComicsBean, BaseViewHolder>(
        R.layout.item_type_content_item_1,
        data
    ) {

    private val imageWidth: Int = DisplayUtils.dp2px(97f)
    private val imageHeight: Int = DisplayUtils.dp2px(160f)

    override fun convert(
        helper: BaseViewHolder?,
        item: RecommendResponse.ComicListsBean.ComicsBean?
    ) {
        helper?.apply {
            item?.also {
                setGone(R.id.v_item_right_bg, adapterPosition == 0)
                setGone(R.id.v_item_left_bg, adapterPosition == data.size - 1)
                setText(R.id.tv_title, it.name)
                addOnClickListener(R.id.frameLayout)
                GlideUtils.loadImage(
                    mContext, it.cover, getView<ImageView>(R.id.iv_cover),
                    0f, imageWidth, imageHeight
                )
            }
        }
    }
}
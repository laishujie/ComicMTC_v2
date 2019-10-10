package com.lai.comicmtc_v2.ui.preview

import androidx.core.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lai.comicmtc_v2.R
import com.lai.comicmtc_v2.bean.detail.ComicDetailResponse

/**
 *
 * @author  Lai
 *
 * @time 2019/10/3 21:49
 * @describe describe
 *
 */
@Deprecated("废弃")
class RightChapterAdapter(data: List<ComicDetailResponse.ChapterListBean>) :
        BaseQuickAdapter<ComicDetailResponse.ChapterListBean, BaseViewHolder>(
                R.layout.item_chapter_right, data
        ) {
    override fun convert(helper: BaseViewHolder?, item: ComicDetailResponse.ChapterListBean?) {
        item?.also {
            if (it.isRead) {
                helper?.setTextColor(R.id.tv_title, ContextCompat.getColor(mContext, R.color.color_3333_80))
                helper?.setText(R.id.tv_title, it.name)?.addOnClickListener(R.id.tv_title)
            } else {
                helper?.setTextColor(R.id.tv_title, ContextCompat.getColor(mContext, R.color.color_333333))
            }
        }
    }
}
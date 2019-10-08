package com.lai.comicmtc_v2.ui.preview

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
class RightChapterAdapter(data: List<ComicDetailResponse.ChapterListBean>) :
    BaseQuickAdapter<ComicDetailResponse.ChapterListBean, BaseViewHolder>(
        R.layout.item_chapter_right, data
    ) {
    override fun convert(helper: BaseViewHolder?, item: ComicDetailResponse.ChapterListBean?) {
        helper?.setText(R.id.tv_title, item?.name)
            ?.addOnClickListener(R.id.tv_title)
    }
}
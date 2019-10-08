package com.lai.comicmtc_v2.ui.detail

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
class ChapterAdapter(data: List<ComicDetailResponse.ChapterListBean>) :
    BaseQuickAdapter<ComicDetailResponse.ChapterListBean, BaseViewHolder>(
        R.layout.item_chapter, data
    ) {
    override fun convert(helper: BaseViewHolder?, item: ComicDetailResponse.ChapterListBean?) {
        //item type ==3 vip？
        if (item?.type.equals("3")) {
            helper?.setAlpha(R.id.tv_title, 0.5f)
                ?.setText(R.id.tv_title, mContext.getString(R.string.no_support_vip_tip))
        } else {
            helper?.setAlpha(R.id.tv_title, 1f)
            helper?.setText(R.id.tv_title, item?.name)
                ?.addOnClickListener(R.id.tv_title)
        }
    }
}
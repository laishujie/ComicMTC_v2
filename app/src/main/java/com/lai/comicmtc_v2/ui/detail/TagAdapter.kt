package com.lai.comicmtc_v2.ui.detail

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lai.comicmtc_v2.R
import com.lai.comicmtc_v2.bean.detail.ComicDetailResponse

/**
 *
 * @author  Lai
 *
 * @time 2019/10/8 15:56
 * @describe describe
 *
 */
class TagAdapter(list: List<ComicDetailResponse.ComicBean.ClassifyTagsBean>) :
    BaseQuickAdapter<ComicDetailResponse.ComicBean.ClassifyTagsBean, BaseViewHolder>(
        R.layout.item_tag_list,
        list
    ) {
    override fun convert(
        helper: BaseViewHolder?,
        item: ComicDetailResponse.ComicBean.ClassifyTagsBean?
    ) {
        helper?.apply {
            item?.also {
                setText(R.id.tv_title, it.name)
            }
        }

    }
}
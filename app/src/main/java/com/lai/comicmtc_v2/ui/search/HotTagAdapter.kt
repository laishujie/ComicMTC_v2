package com.lai.comicmtc_v2.ui.search

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lai.comicmtc_v2.R
import com.lai.comicmtc_v2.bean.search.SeachHotResponse

/**
 *
 * @author  Lai
 *
 * @time 2019/10/8 15:56
 * @describe describe
 *
 */
class HotTagAdapter(list: List<SeachHotResponse.HotItemsBean>) :
    BaseQuickAdapter<SeachHotResponse.HotItemsBean, BaseViewHolder>(
        R.layout.item_tag_hot_list,
        list
    ) {
    override fun convert(
        helper: BaseViewHolder?,
        item: SeachHotResponse.HotItemsBean?
    ) {
        helper?.apply {
            item?.also {
                setText(R.id.tv_title, it.name)
                addOnClickListener(R.id.tv_title)
            }
        }

    }
}
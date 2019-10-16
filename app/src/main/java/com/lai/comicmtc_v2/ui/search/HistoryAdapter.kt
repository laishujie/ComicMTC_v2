package com.lai.comicmtc_v2.ui.search

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lai.comicmtc_v2.R
import com.lai.comicmtc_v2.db.HistoryRecord

/**
 *
 * @author  Lai
 *
 * @time 2019/10/8 15:56
 * @describe describe
 *
 */
class HistoryAdapter(list: List<HistoryRecord>) :
    BaseQuickAdapter<HistoryRecord, BaseViewHolder>(
        R.layout.item_search_hisroty,
        list
    ) {
    override fun convert(
        helper: BaseViewHolder?,
        item: HistoryRecord?
    ) {
        helper?.apply {
            item?.also {
                setText(R.id.tv_title, it.name)
                addOnClickListener(R.id.iv_delete)
                addOnClickListener(R.id.tv_title)
            }
        }

    }
}
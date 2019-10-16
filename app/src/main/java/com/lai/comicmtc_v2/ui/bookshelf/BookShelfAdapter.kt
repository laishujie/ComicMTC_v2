package com.lai.comicmtc_v2.ui.bookshelf

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lai.comicmtc_v2.R
import com.lai.comicmtc_v2.db.ComicCollection
import com.lai.comicmtc_v2.utils.GlideUtils

/**
 *
 * @author  Lai
 *
 * @time 2019/10/14 15:57
 * @describe describe
 *
 */
class BookShelfAdapter(data:List<ComicCollection>) :
    BaseQuickAdapter<ComicCollection,BaseViewHolder>(R.layout.item_book_shelf_item,data){

    override fun convert(helper: BaseViewHolder?, item: ComicCollection?) {
        helper?.apply {
            item?.also {
                setText(R.id.tv_title, it.comicName)
                addOnClickListener(R.id.iv_cover)
                GlideUtils.loadImage(mContext, it.coverUrl, getView(R.id.iv_cover),
                    0f)
            }
        }
    }

}
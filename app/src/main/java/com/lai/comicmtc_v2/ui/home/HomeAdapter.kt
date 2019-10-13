package com.lai.comicmtc_v2.ui.home

import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseQuickAdapter.SpanSizeLookup
import com.chad.library.adapter.base.BaseViewHolder
import com.lai.comicmtc_v2.R
import com.lai.comicmtc_v2.bean.home.HomeTypeInfo
import com.lai.comicmtc_v2.utils.DecorationUtils
import com.lai.comicmtc_v2.utils.DisplayUtils
import com.lai.comicmtc_v2.utils.GlideUtils

/**
 *
 * @author  Lai
 *
 * @time 2019/10/1 23:20
 * @describe describe
 *
 */
class HomeAdapter(data: List<HomeTypeInfo>) : BaseMultiItemQuickAdapter<HomeTypeInfo, BaseViewHolder>(data) {

    init {
        addItemType(HomeTypeInfo.TITLE, R.layout.item_type_title)
        addItemType(HomeTypeInfo.HEARD_LIST, R.layout.item_type_list)
        addItemType(HomeTypeInfo.CONTENT_1, R.layout.item_type_content_1)
        addItemType(HomeTypeInfo.BANNER, R.layout.item_type_banner)
        addItemType(HomeTypeInfo.CONTENT_2, R.layout.iten_tyoe_content_2)
    }

    init {
        setSpanSizeLookup(SpanSizeLookup { _, position ->
            return@SpanSizeLookup when (getDefItemViewType(position)) {
                //每行的item个数= spanCount/?
                //这个直接占满全格子
                HomeTypeInfo.TITLE, HomeTypeInfo.HEARD_LIST, HomeTypeInfo.BANNER -> 6
                //每个item占位2个
                HomeTypeInfo.CONTENT_2 -> 3
                //每个item占位3个
                else -> 2
            }
        })
    }

    override fun convert(helper: BaseViewHolder?, item: HomeTypeInfo?) {
        helper?.apply {
            item?.also {
                when (it.itemType) {
                    HomeTypeInfo.TITLE -> {
                        GlideUtils.loadImage(mContext, it.title?.titleIconUrl, getView<ImageView>(R.id.iv_icon),
                                0f)
                        setText(R.id.tv_title, it.title?.itemTitle)
                    }
                    HomeTypeInfo.HEARD_LIST -> {
                        val recyclerView = getView<RecyclerView>(R.id.rv_list)
                        if (recyclerView.adapter == null || recyclerView.adapter !is HomeListItemAdapter1) {
                            val adapter = HomeListItemAdapter1(it.comicList!!)
                            recyclerView.isNestedScrollingEnabled = false
                            adapter.onItemChildClickListener = onItemChildClickListener
                            recyclerView.addItemDecoration(HomeSortItemDecoration(0, DisplayUtils.dp2px(6f), DisplayUtils.dp2px(6f)))
                            recyclerView.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
                            adapter.bindToRecyclerView(recyclerView)
                        } else {
                            val adapter = recyclerView.adapter as HomeListItemAdapter1
                            adapter.setNewData(it.comicList!!)
                        }
                    }
                    HomeTypeInfo.CONTENT_1 -> {
                        setText(R.id.tv_title, it.comic?.name)
                        setGone(R.id.v_item_right_bg, DecorationUtils.isFirstColumn(3, it.listIndex))
                        setGone(R.id.v_item_left_bg, DecorationUtils.isLastColumn(recyclerView, it.listIndex, 3))
                        addOnClickListener(R.id.iv_cover)
                        GlideUtils.loadImage(mContext, it.comic?.cover, getView(R.id.iv_cover),
                                0f)
                    }
                    HomeTypeInfo.BANNER -> {
                        setText(R.id.tv_title, it.comic?.title)
                        GlideUtils.loadImage(mContext, it.comic?.cover, getView<ImageView>(R.id.iv_cover),
                                0f)
                    }
                    HomeTypeInfo.CONTENT_2 -> {
                        addOnClickListener(R.id.iv_cover)
                        GlideUtils.loadImage(mContext, it.comic?.cover, getView(R.id.iv_cover),
                                0f)
                        setText(R.id.tv_title, it.comic?.name)
                                .setText(R.id.tv_sub_title, it.comic?.subTitle)
                                .setText(R.id.tv_des, it.comic?.description)
                                .setText(R.id.tv_author, it.comic?.author_name)
                    }
                }
            }
        }
    }

}
package com.lai.comicmtc_v2.bean.home

import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 *
 * @author  Lai
 *
 * @time 2019/9/23 14:49
 * @describe describe
 *
 */
class HomeTypeInfo(type: Int = TITLE) : MultiItemEntity {

    var currItemType = type
    var galleryItems: List<RecommendResponse.GalleryItemsBean>? = null
    var comic: RecommendResponse.ComicListsBean.ComicsBean? = null
    var comicList: List<RecommendResponse.ComicListsBean.ComicsBean>? = null
    var title: Title? = null
    var listIndex = 0
    //comicType 九宫格

    companion object {
        const val BANNER = 1
        const val TITLE = 2
        const val CONTENT_1 = 3
        const val CONTENT_2 = 4
        const val HEARD_LIST = 5
    }

    override fun getItemType(): Int {
        return currItemType
    }

    fun setTitleInfo(comicListsBean: RecommendResponse.ComicListsBean) {
        val title = Title()
        title.itemTitle = comicListsBean.itemTitle
        title.comicType = comicListsBean.comicType
        title.description = comicListsBean.description
        title.titleIconUrl = comicListsBean.titleIconUrl
        this.title = title
    }

    class Title {
        var comicType: Int = 0
        var canedit: Int = 0
        var sortId: String? = null
        var titleIconUrl: String? = null
        var newTitleIconUrl: String? = null
        var description: String? = null
        var itemTitle: String? = null
        var argName: String? = null
        var argValue: Int = 0
        var argType: Int = 0
    }
}
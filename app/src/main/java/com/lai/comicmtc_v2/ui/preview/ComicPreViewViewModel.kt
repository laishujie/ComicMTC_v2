package com.lai.comicmtc_v2.ui.preview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lai.comicmtc_v2.bean.detail.ComicDetailResponse
import com.lai.comicmtc_v2.bean.preview.ComicPreViewResponse
import com.lai.comicmtc_v2.db.BookDao
import com.lai.comicmtc_v2.http.RetrofitClient
import com.lai.comicmtc_v2.ui.comm.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *
 * @author  Lai
 *
 * @time 2019/10/4 14:51
 * @describe describe
 *
 */
class ComicPreViewViewModel : BaseViewModel() {
    val mPerViewResponse = MutableLiveData<ComicPreViewResponse>()
    //当前最新章节信息
    private var mCurrRequestNewChapterBean: ComicDetailResponse.ChapterListBean? = null

    private val mBookDao by lazy { BookDao() }


    fun setCurrChapterInfo(currRequestNewChapterBean: ComicDetailResponse.ChapterListBean) {
        this.mCurrRequestNewChapterBean = currRequestNewChapterBean
    }


    fun getPreView(chapterId: String) {
        request({
            val comicPreView = RetrofitClient.service.comicPreView(chapterId)
            mCurrRequestNewChapterBean?.also {
                val imageList = comicPreView.data?.returnData?.image_list
                imageList?.forEachIndexed { index, imageListBean ->
                    imageListBean.chapterName = it.name
                    imageListBean.listIndex = index + 1
                    imageListBean.listSize = imageList.size
                    imageListBean.chapter_id = it.chapter_id
                }
                mBookDao.finReadChapterById(it.chapter_id)?.apply {
                    comicPreView.data?.returnData?.position = this.readPosition
                }
            }
            comicPreView
        }, {
            mPerViewResponse.value = it.returnData
        })
    }

    fun saveReadChapter(
        comicId: String?,
        comicName: String?,
        chapter_id: String,
        chapterName: String,
        type: String
    ): Boolean {
        if (comicId != null && comicName != null)
            return mBookDao.saveReadChapter(
                comicId, comicName, chapter_id,
                chapterName, type
            )
        return false

    }


    fun saveReadPosition(chapter_id: String, position: Int) {
        viewModelScope.launch(Dispatchers.IO) {
          val status =   mBookDao.saveReadPosition(chapter_id, position)
            com.orhanobut.logger.Logger.e("-- 保存阅读位置 $position status $status")
        }
    }

}
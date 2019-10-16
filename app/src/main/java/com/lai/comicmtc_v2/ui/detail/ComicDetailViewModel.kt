package com.lai.comicmtc_v2.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lai.comicmtc_v2.bean.detail.ComicDetailResponse
import com.lai.comicmtc_v2.db.BookDao
import com.lai.comicmtc_v2.db.ReadChapter
import com.lai.comicmtc_v2.http.RetrofitClient
import com.lai.comicmtc_v2.ui.comm.BaseViewModel
import com.orhanobut.logger.Logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *
 * @author  Lai
 *
 * @time 2019/10/3 21:16
 * @describe describe
 *
 */
class ComicDetailViewModel : BaseViewModel() {

    var mComicDetailResponse = MutableLiveData<ComicDetailResponse>()

    var mSaveReadChapter = MutableLiveData<ComicDetailResponse.ChapterListBean?>()

    var mLastChapterBean = MutableLiveData<ComicDetailResponse.ChapterListBean?>()
    //收藏 true 已收藏 false 收藏
    var mSaveCollection = MutableLiveData<Boolean>()

    private val mBookDao by lazy {
        BookDao()
    }

    fun getComicDetail(comicId: String) {
        request({
            val detailResponse = RetrofitClient.service.comicDetail(comicId)
            val returnData = detailResponse.data?.returnData
            returnData?.apply {
                val db = mBookDao.finReadChapterList(comic.comic_id)
                if (db.isNotEmpty())
                    chapter_list = setIsRead(chapter_list, db)
            }
            detailResponse
        }, {
            mComicDetailResponse.value = it.returnData
        })
    }


    private fun setIsRead(
        requestList: List<ComicDetailResponse.ChapterListBean>,
        dbList: List<*>
    ): List<ComicDetailResponse.ChapterListBean> {
        for (bean in requestList) {
            val indexOf = dbList.indexOf(bean)
            if (indexOf != -1) {
                val dbInfo = dbList[indexOf]
                if (dbInfo is ReadChapter) {
                    bean.isRead = true
                }
            }
        }
        return requestList
    }


    fun getLastChapter(comicId: String) {
        viewModelScope.launch {
            val chapter = withContext(Dispatchers.IO) {
                mBookDao.findLastReadChapter(comicId)
            }
            chapter?.apply {
                val bean = ComicDetailResponse.ChapterListBean()
                bean.chapter_id = chapter_id
                bean.name = chapterName
                bean.type = type
                mLastChapterBean.value = bean
            }
        }
    }

    fun saveAndCancelCollection(comicBean: ComicDetailResponse.ComicBean,size:Int,readChapter:Int = -1) {
        viewModelScope.launch {
            mSaveCollection.value = withContext(Dispatchers.IO) {
                val findCollection = mBookDao.findCollection(comicBean.comic_id)
                if (findCollection == null) {
                    return@withContext mBookDao.saveCollection(comicBean,size,readChapter)
                } else {
                    return@withContext mBookDao.deleteCollection(comicBean.comic_id) == 0
                }
            }
        }
    }

    fun getCollectionStatus(comicBean: ComicDetailResponse.ComicBean) {
        viewModelScope.launch {
            mSaveCollection.value = withContext(Dispatchers.IO) {
                return@withContext mBookDao.findCollection(comicBean.comic_id) != null
            }
        }
    }


    /**
     * 保存章节阅读记录
     */
    fun saveReadChapter(
        book: ComicDetailResponse.ComicBean,
        chapterListBean: ComicDetailResponse.ChapterListBean
    ) {
        viewModelScope.launch {
            mSaveReadChapter.value = withContext(Dispatchers.IO) {
                if (!mBookDao.saveReadChapter(
                        book.comic_id, book.name, chapterListBean.chapter_id
                        , chapterListBean.name, chapterListBean.type
                    )
                ) {
                    return@withContext null
                }
                chapterListBean
            }
        }
    }


    /**
     * 保存历史记录
     */
    fun saveHistoryRecord(book: ComicDetailResponse.ComicBean){
        viewModelScope.launch(Dispatchers.IO){
            mBookDao.saveHistoryRecord(book)
        }
    }

    override fun onCleared() {
        super.onCleared()
        Logger.e("-- onCleared")
    }

}
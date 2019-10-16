package com.lai.comicmtc_v2.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lai.comicmtc_v2.bean.search.ComicSearchResponse
import com.lai.comicmtc_v2.bean.search.SeachHotResponse
import com.lai.comicmtc_v2.db.BookDao
import com.lai.comicmtc_v2.db.HistoryRecord
import com.lai.comicmtc_v2.http.RetrofitClient
import com.lai.comicmtc_v2.ui.comm.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *
 * @author  Lai
 *
 * @time 2019/10/14 16:02
 * @describe describe
 *
 */
class SearchViewModel : BaseViewModel() {

    val mSearchBean = MutableLiveData<SeachHotResponse>()
    val mHistoryBean = MutableLiveData<List<HistoryRecord>>()

    val mSearchResult = MutableLiveData<ComicSearchResponse>()

    private val mBookDao by lazy {
        BookDao()
    }

    fun getSearchHot() {
        request({
            RetrofitClient.service.comicSearchHot()
        }, {
            mSearchBean.value = it.returnData
        })
    }

    fun getHistory() {
        viewModelScope.launch {
            mHistoryBean.value = withContext(Dispatchers.IO) {
                return@withContext mBookDao.findHistoryRecord()
            }
        }
    }

    fun getSearchResult(str: String, pager: Int) {
        request({
            RetrofitClient.service.comicSearch(str,pager)
        }, {
            mSearchResult.value = it.returnData
        })
    }

    fun deleteHistoryRecord(comicId: String): Int {
        return mBookDao.deleteHistoryRecord(comicId)
    }

}
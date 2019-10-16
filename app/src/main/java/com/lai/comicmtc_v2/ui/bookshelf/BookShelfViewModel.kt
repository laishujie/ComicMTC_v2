package com.lai.comicmtc_v2.ui.bookshelf

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lai.comicmtc_v2.db.BookDao
import com.lai.comicmtc_v2.db.ComicCollection
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
class BookShelfViewModel : BaseViewModel() {


     val mCollection = MutableLiveData<List<ComicCollection>>()

    private val mBookDao by lazy {
        BookDao()
    }

    fun getAllCollection() {
        viewModelScope.launch {
            mCollection.value = withContext(Dispatchers.IO) {
                return@withContext mBookDao.finAllCollection()
            }
        }

    }


}
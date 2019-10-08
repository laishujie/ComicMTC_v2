package com.lai.comicmtc_v2.ui.detail

import androidx.lifecycle.MutableLiveData
import com.lai.comicmtc_v2.bean.detail.ComicDetailResponse
import com.lai.comicmtc_v2.http.RetrofitClient
import com.lai.comicmtc_v2.ui.comm.BaseViewModel

/**
 *
 * @author  Lai
 *
 * @time 2019/10/3 21:16
 * @describe describe
 *
 */
class ComicDetailViewModel:BaseViewModel() {

    var mComicDetailResponse = MutableLiveData<ComicDetailResponse>()


    fun getComicDetail(comicId:Int){
        request({RetrofitClient.service.comicDetail(comicId)},{
            mComicDetailResponse.value = it.returnData
        })
    }

}
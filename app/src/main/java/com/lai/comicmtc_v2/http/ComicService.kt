package com.lai.comicmtc_v2.http

import com.lai.comicmtc_v2.bean.comm.ComicResponse
import com.lai.comicmtc_v2.bean.detail.ComicDetailResponse
import com.lai.comicmtc_v2.bean.home.RecommendResponse
import com.lai.comicmtc_v2.bean.preview.ComicPreViewResponse
import com.lai.comicmtc_v2.bean.search.ComicSearchResponse
import com.lai.comicmtc_v2.bean.search.SeachHotResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 * @author  Lai
 *
 * @time 2019/9/20 15:56
 * @describe describe
 *
 */
interface ComicService {
    companion object {
        const val BASE_URL = "http://app.u17.com/v3/appV3_3/android/phone/"
    }

    @GET("comic/boutiqueListNew")
    suspend fun boutiqueList(@Query("sexType") sexType: Int = 1): ComicResponse<RecommendResponse>

    @GET("comic/detail_static_new")
    suspend fun comicDetail(@Query("comicid") comicId: String): ComicResponse<ComicDetailResponse>

    @GET("comic/chapterNew")
    suspend fun comicPreView(@Query("chapter_id") chapter_id: String): ComicResponse<ComicPreViewResponse>

    @GET("search/searchResult")
    suspend fun comicSearch(@Query("q") text: String, @Query("page") page: Int): ComicResponse<ComicSearchResponse>

    @GET("search/hotkeywordsnew")
    suspend fun comicSearchHot(): ComicResponse<SeachHotResponse>

}
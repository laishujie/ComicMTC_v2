package com.lai.comicmtc_v2.ui.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.google.android.material.appbar.AppBarLayout
import com.gyf.barlibrary.ImmersionBar
import com.lai.comicmtc_v2.R
import com.lai.comicmtc_v2.bean.detail.ComicDetailResponse
import com.lai.comicmtc_v2.bean.detail.ComicDetailResponse.ChapterListBean
import com.lai.comicmtc_v2.ui.comm.ActivityLauncher
import com.lai.comicmtc_v2.ui.comm.BaseVMActivity
import com.lai.comicmtc_v2.ui.home.HomeSortItemDecoration
import com.lai.comicmtc_v2.ui.preview.ComicPreViewActivity
import com.lai.comicmtc_v2.utils.ArithHelper
import com.lai.comicmtc_v2.utils.DisplayUtils
import com.lai.comicmtc_v2.utils.GlideUtils
import kotlinx.android.synthetic.main.activity_comic_detail_new.*
import kotlin.math.abs

/**
 *
 * @author  Lai
 *
 * @time 2019/10/3 21:12
 * @describe describe 详情页
 *
 */
class ComicDetailActivity : BaseVMActivity(), BaseQuickAdapter.OnItemChildClickListener,
    View.OnClickListener {

    //详情ViewModel
    private var mDetailViewModel: ComicDetailViewModel? = null
    //当前的漫画id
    private var mComicId: String = ""
    //请求回来的详情
    private var mComicDetailResponse: ComicDetailResponse? = null
    //最近阅读的书
    private var mRecentReadingChapter: ChapterListBean? = null
    //当前点击listPosition
    private var mCurrChapterPosition = 0

    //是否翻转过list
    private var isReverseList = false

    //activity result call
    private val resultCall = object : ActivityLauncher.Callback {
        override fun onActivityResult(resultCode: Int, data: Intent?) {
            data?.apply {
                val booleanExtra = getBooleanExtra(ComicPreViewActivity.NEED_UPDATE_DETAIL, false)
                if (booleanExtra) {
                    request()
                }
            }
        }
    }

    companion object {
        const val COMIC_ID = "comicId"

        fun openActivity(content: Activity, comId: String?) {
            val intent = Intent(content, ComicDetailActivity::class.java)
            intent.putExtra(COMIC_ID, comId)
            content.startActivity(intent)
        }
    }


    override fun getLayout(): Int {
        return R.layout.activity_comic_detail_new
    }

    override fun init(savedInstanceState: Bundle?) {
        mComicId = intent.getStringExtra(COMIC_ID)
        if (TextUtils.isEmpty(mComicId)) {
            toast("id为空")
            finish()
        }

        mDetailViewModel = createViewModel()

        val statusBarHeight = ImmersionBar.getStatusBarHeight(this)
        cl_layout.setPadding(0, statusBarHeight, 0, 0)
        ImmersionBar.setTitleBar(this, ac_toolbar)

        setToolBar(ac_toolbar, getString(R.string.details))


        ac_appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val totalScrollRange = appBarLayout.totalScrollRange
            val percent = 1 - ArithHelper.div(abs(verticalOffset), totalScrollRange)
            cl_layout.alpha = percent
        })

        //监听请求网络返回来的数据
        mDetailViewModel?.mComicDetailResponse?.observe(this, Observer {
            hideLoading()

            val comic = it.comic

            if (mComicDetailResponse == null) {
                mComicDetailResponse = it
                GlideUtils.loadImage(this, comic.cover, iv_cover, 0f)
                tv_title.text = comic.name
                tv_author.text = comic.author.name
                tv_des_content.text = comic.description
                GlideUtils.loadImage(this, comic.wideCover, iv_bg, 0f)
                comic.classifyTags?.also { list ->
                    val tagAdapter = TagAdapter(list)
                    rv_tag_list.layoutManager =
                        LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                    rv_tag_list.addItemDecoration(
                        HomeSortItemDecoration(
                            DisplayUtils.dp2px(5f)
                            , DisplayUtils.dp2px(15f), DisplayUtils.dp2px(15f)
                        )
                    )
                    tagAdapter.bindToRecyclerView(rv_tag_list)
                }
                val chapterAdapter = ChapterAdapter(it.chapter_list)
                chapterAdapter.onItemChildClickListener = this
                rv_list.layoutManager = GridLayoutManager(this, 2)
                rv_list.addItemDecoration(ChapterDecoration())
                chapterAdapter.bindToRecyclerView(rv_list)
            } else {
                getAdapter<ChapterAdapter>(rv_list)?.apply {
                    setNewData(it.chapter_list)
                }
            }
            //获取是否有最近的阅读记录
            mDetailViewModel?.getLastChapter(comic.comic_id)
            mDetailViewModel?.getCollectionStatus(comic)
            mDetailViewModel?.saveHistoryRecord(comic)
        })

        //监控保存阅读记录返回来的数据
        mDetailViewModel?.mSaveReadChapter?.observe(this, Observer {
            if (it == null) {
                toast(getString(R.string.save_chapter_fail))
            } else {
                updateListRecordAndBtnUI(mCurrChapterPosition)

                getAdapter<ChapterAdapter>(rv_list)?.apply {
                    ComicPreViewActivity.openActivity(
                        this@ComicDetailActivity,
                        it,
                        data as List<ChapterListBean>,
                        isReverseList,
                        mComicDetailResponse?.comic
                    ,resultCall)
                }
            }
        })

        //最近阅读记录监控
        mDetailViewModel?.mLastChapterBean?.observe(this, Observer {
            it?.apply {
                mRecentReadingChapter = this
                val readTip = String.format(getString(R.string.read_on_str), name)
                btn_preview.text = readTip
            }
        })

        mDetailViewModel?.mSaveCollection?.observe(this, Observer {
            val text = if(it) "已收藏" else "收藏"
            tv_favorite.text = text
        })

        request()

        iv_reverse.setOnClickListener(this)
        btn_preview.setOnClickListener(this)
        tv_favorite.setOnClickListener(this)
    }

    /**
     * 更新按钮阅读状态
     * 以及列表状态
     */
    private fun updateListRecordAndBtnUI(position: Int) {
        //更新
        mComicDetailResponse?.also { data ->
            //更新阅读btn文字
            mDetailViewModel?.getLastChapter(data.comic.comic_id)
        }
        getAdapter<ChapterAdapter>(rv_list)?.also { adapter ->
            //更新列表状态
            adapter.apply {
                getItem(position)?.also {
                    if (!it.isRead) {
                        it.isRead = true
                        notifyItemChanged(position)
                    }
                }
            }
        }
    }

    /**
     * 请求网络
     */
    private fun request() {
        showLoading()
        mDetailViewModel?.getComicDetail(mComicId)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_reverse -> {
                rv_list.adapter?.apply {
                    val adapter = this as ChapterAdapter
                    val data = adapter.data
                    data.reverse<ChapterListBean>()
                    adapter.notifyDataSetChanged()
                    isReverseList = !isReverseList
                }
            }
            R.id.btn_preview -> {
                getAdapter<ChapterAdapter>(rv_list)?.apply {
                    if (mRecentReadingChapter == null) {
                        getItem(0)?.also {
                            //保存阅读记录
                            mComicDetailResponse?.also { response ->
                                mDetailViewModel?.saveReadChapter(response.comic, it)
                            }
                        }
                    } else {
                        ComicPreViewActivity.openActivity(
                            this@ComicDetailActivity,
                            mRecentReadingChapter,
                            data,
                            isReverseList,
                            mComicDetailResponse?.comic,
                                    resultCall)
                    }
                }
            }
            R.id.tv_favorite->{
                mComicDetailResponse?.apply {
                    val listPosition = chapter_list.indexOf(mRecentReadingChapter)
                    mDetailViewModel?.saveAndCancelCollection(comic,chapter_list.size,listPosition)
                }
            }
        }
    }


    /**
     * 点击事件
     */
    override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        adapter?.getItem(position)?.apply {
            this as ChapterListBean
            if (type == "3") {
                toast(getString(R.string.no_support_vip_tip))
            } else {
                mCurrChapterPosition = position
                //保存阅读记录
                mComicDetailResponse?.also {
                    mDetailViewModel?.saveReadChapter(it.comic, this)
                }
            }
        }
    }


}
package com.lai.comicmtc_v2.ui.preview

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.core.view.ViewCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.gyf.barlibrary.ImmersionBar
import com.lai.comicmtc_v2.R
import com.lai.comicmtc_v2.bean.detail.ComicDetailResponse
import com.lai.comicmtc_v2.ui.comm.BaseVMActivity
import com.lai.comicmtc_v2.utils.DisplayUtils
import com.lai.comicmtc_v2.utils.ViewUtils
import kotlinx.android.synthetic.main.activity_preview.*
import kotlinx.android.synthetic.main.comic_activity_preview_bottom_menu.*
import kotlinx.android.synthetic.main.comic_activity_preview_right_menu.*
import kotlinx.android.synthetic.main.comic_preview_title.*


/**
 *
 * @author  Lai
 *
 * @time 2019/10/4 15:11
 * @describe describe
 *
 */
class ComicPreViewActivity : BaseVMActivity(), View.OnClickListener,
    BaseQuickAdapter.RequestLoadMoreListener {
    private val mViewModel by lazy { createViewModel<ComicPreViewViewModel>() }
    //已读章节
    private val mReadChapterList = ArrayList<ComicDetailResponse.ChapterListBean>()
    //当前请求最新的章节
    lateinit var mCurrRequestNewChapterBean: ComicDetailResponse.ChapterListBean
    //所有章节集合
    private var mAllChapterList: List<ComicDetailResponse.ChapterListBean>? = null


    private var mComicPreAdapter: ComicPreAdapter? = null

    companion object {
        private const val CHAPTER_LIST = "chapter_list"
        private const val CHAPTER = "chapter"

        fun openActivity(
            content: Activity,
            chapter: ComicDetailResponse.ChapterListBean?,
            data: List<ComicDetailResponse.ChapterListBean>
        ) {
            val intent = Intent(content, ComicPreViewActivity::class.java)
            intent.putExtra(CHAPTER, chapter)
            intent.putParcelableArrayListExtra(CHAPTER_LIST, ArrayList(data))

            content.startActivity(intent)
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_preview
    }

    override fun init(savedInstanceState: Bundle?) {
        mCurrRequestNewChapterBean = intent.getParcelableExtra(CHAPTER)
        mAllChapterList = intent.getParcelableArrayListExtra(CHAPTER_LIST)
        mReadChapterList.add(mCurrRequestNewChapterBean)

        mViewModel.setCurrChapterInfo(mCurrRequestNewChapterBean)
        mComicPreAdapter?.setPreLoadNumber(5)
        ImmersionBar.setTitleBar(this, ac_toolbar)
        hideLayout()
        setToolBar(ac_toolbar, mCurrRequestNewChapterBean.name)

        rv_list.setITouchCallBack {
            if (ll_right_layout.translationX == 0f)
                switchRightMenu()
            else
                switchBAndTMenu()
        }
        rv_list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager
                    val findFirstVisibleItemPosition =
                        linearLayoutManager.findFirstVisibleItemPosition()

                    mComicPreAdapter?.getItem(findFirstVisibleItemPosition)?.also {
                        updateCurrPagerProcess(it.listIndex, it.listSize, it.comicName)
                    }
                }
            }
        })

        //监听集数的返回
        mViewModel.mPerViewResponse.observe(this, Observer {
            hideLoading()
            when (rv_list.adapter) {
                null -> {
                    mComicPreAdapter = ComicPreAdapter(it.image_list)
                    rv_list.layoutManager = LinearLayoutManager(this)
                    mComicPreAdapter?.bindToRecyclerView(rv_list)
                    mComicPreAdapter?.setEnableLoadMore(true)
                    mComicPreAdapter?.setOnLoadMoreListener(this, rv_list)
                    updateCurrPagerProcess(1, it.image_list.size, mCurrRequestNewChapterBean.name)
                }
                else -> {
                    mComicPreAdapter?.addData(it.image_list)
                    mComicPreAdapter?.loadMoreComplete()
                }
            }
        })

        tv_right_title.text = mCurrRequestNewChapterBean.name
        tv_menu.setOnClickListener(this)


        request(true)
    }


    /**
     * 更新当前右下角最新集数以及更新seekBar进度
     *
     */
    private fun updateCurrPagerProcess(index: Int, size: Int, title: String) {
        val format = String.format(
            getString(R.string.current_set_number),
            title,
            index,
            size
        )
        sb_bar.max = size
        sb_bar.progress = index
        tv_curr_pager.text = format
    }

    //返回键
    override fun onBackPressedSupport() {
        when {
            ll_right_layout.translationX == 0f -> switchRightMenu()
            ll_bottom.translationY == 0f -> switchBAndTMenu()
            else -> super.onBackPressedSupport()
        }
    }

    /**
     * 设置TranslationY,X隐藏底部/顶部布局/左边菜单
     */
    private fun hideLayout() {
        ll_bottom.translationY = ViewUtils.getViewMeasuredHeight(ll_bottom).toFloat()
        ac_toolbar.translationY =
            -ViewUtils.getViewMeasuredHeight(ac_toolbar) - ImmersionBar.getStatusBarHeight(this).toFloat()
        ll_right_layout.translationX = (DisplayUtils.getScreenWidth()).toFloat()
        ImmersionBar.hideStatusBar(window)
        ll_bottom.visibility = View.VISIBLE
        ac_toolbar.visibility = View.VISIBLE
        ll_right_layout.visibility = View.VISIBLE
    }

    private fun request(hasLoading: Boolean = false) {
        if (hasLoading)
            showLoading()
        mViewModel.getPreView(mCurrRequestNewChapterBean.chapter_id)
    }


    /**
     * 顶部和底部菜单切换
     */
    private fun switchBAndTMenu() {
        if (ll_bottom.translationY != 0f) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            ViewCompat.animate(ll_bottom).translationY(0f).duration = 300
            ViewCompat.animate(ac_toolbar).translationY(0f).duration = 300
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
            ViewCompat.animate(ll_bottom).translationY(ll_bottom.height.toFloat()).duration = 300
            ViewCompat.animate(ac_toolbar).translationY(-ac_toolbar.height.toFloat()).duration = 300
        }
    }


    /**
     * 左边菜单切换
     */
    private fun switchRightMenu() {
        if (ll_right_layout.translationX != 0f) {
            if (rv_right_list.adapter == null && mAllChapterList != null) {
                val adapter = RightChapterAdapter(mAllChapterList!!)
                rv_right_list.layoutManager = LinearLayoutManager(this)
                adapter.bindToRecyclerView(rv_right_list)
            }
            ViewCompat.animate(ll_right_layout).translationX(0f).duration = 300
        } else {
            ViewCompat.animate(ll_right_layout).translationX(ll_right_layout.width.toFloat())
                .duration = 300
        }
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_menu -> {
                if (ll_bottom.translationY == 0f) {
                    switchBAndTMenu()
                }
                switchRightMenu()
            }
        }
    }

    override fun onLoadMoreRequested() {
        mAllChapterList?.indexOf(mCurrRequestNewChapterBean)?.also { position ->
            if (position != -1 && position + 1 <= mAllChapterList!!.size) {
                mCurrRequestNewChapterBean = mAllChapterList?.get(position + 1)!!
                mViewModel.setCurrChapterInfo(mCurrRequestNewChapterBean)
                mReadChapterList.add(mCurrRequestNewChapterBean)
                request()
            } else {
                mComicPreAdapter?.loadMoreEnd()
                toast(getString(R.string.last_tip))
            }
        }
    }

}
package com.lai.comicmtc_v2.ui.preview

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.SparseArray
import android.view.View
import android.view.WindowManager
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.gyf.barlibrary.ImmersionBar
import com.lai.comicmtc_v2.R
import com.lai.comicmtc_v2.bean.detail.ComicDetailResponse
import com.lai.comicmtc_v2.ui.comm.ActivityLauncher
import com.lai.comicmtc_v2.ui.comm.BaseVMActivity
import com.lai.comicmtc_v2.ui.detail.ChapterAdapter
import com.lai.comicmtc_v2.ui.widget.PreCacheLayoutManager
import com.lai.comicmtc_v2.utils.DisplayUtils
import com.lai.comicmtc_v2.utils.Preference
import com.lai.comicmtc_v2.utils.ViewUtils
import com.orhanobut.logger.Logger
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
    BaseQuickAdapter.RequestLoadMoreListener, BaseQuickAdapter.OnItemChildClickListener,
    SeekBar.OnSeekBarChangeListener {
    private val mViewModel by lazy { createViewModel<ComicPreViewViewModel>() }
    //当前请求最新的章节
    private lateinit var mCurrRequestNewChapterBean: ComicDetailResponse.ChapterListBean
    //所有章节集合
    private var mAllChapterList: ArrayList<ComicDetailResponse.ChapterListBean>? = null

    private var mComicPreAdapter: ComicPreAdapter? = null
    //对应的书本id和书本名称
    private var comicId: String? = null
    private var comicName: String? = null
    //是否是横向阅读模式
    private var isHorizontal by Preference(Preference.PREVIEW_HORIZONTAL_MODEL, false)
    //是否夜间模式
    private var isNightModel by Preference(Preference.NIGHT_BRIGHTNESS_MODEL, false)

    //已经阅读过的章节,并保存到数据的ChapterID
    private val mSaveChapterList = SparseArray<String>()
    //当前chapterId对应章节的position
    private val mChapterListPosition = HashMap<String, Int>()


    override fun finish() {
        if (mSaveChapterList.size() != 0) {
            val intent = Intent()
            intent.putExtra(NEED_UPDATE_DETAIL, true)
            setResult(Activity.RESULT_OK, intent)
        }
        super.finish()
    }


    companion object {
        private const val CHAPTER_LIST = "chapter_list"
        private const val CHAPTER = "chapter"
        private const val IS_REVERSE_LIST = "isReverseList"
        private const val COMIC_ID = "comic_id"
        private const val COMIC_NAME = "comic_name"
        const val NEED_UPDATE_DETAIL = "need_update_detail"

        fun openActivity(
            content: AppCompatActivity,
            chapter: ComicDetailResponse.ChapterListBean?,
            data: List<ComicDetailResponse.ChapterListBean>,
            isReverseList: Boolean,
            comic: ComicDetailResponse.ComicBean?,
            resultCallback: ActivityLauncher.Callback
        ) {
            val intent = Intent(content, ComicPreViewActivity::class.java)
            intent.putExtra(CHAPTER, chapter)
            intent.putExtra(IS_REVERSE_LIST, isReverseList)
            intent.putParcelableArrayListExtra(CHAPTER_LIST, ArrayList(data))
            comic?.apply {
                intent.putExtra(COMIC_ID, comic_id)
                intent.putExtra(COMIC_NAME, name)
            }
            ActivityLauncher.init(content).startActivityForResult(intent, resultCallback)
            //content.startActivity(intent)
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_preview
    }

    override fun init(savedInstanceState: Bundle?) {
        mCurrRequestNewChapterBean = intent.getParcelableExtra(CHAPTER)
        mAllChapterList = intent.getParcelableArrayListExtra(CHAPTER_LIST)
        if (intent.getBooleanExtra(IS_REVERSE_LIST, false)) {
            mAllChapterList?.reverse()
        }
        comicId = intent.getStringExtra(COMIC_ID)
        comicName = intent.getStringExtra(COMIC_NAME)

        initConfigInfoByUi()

        mViewModel.setCurrChapterInfo(mCurrRequestNewChapterBean)

        ImmersionBar.setTitleBar(this, ac_toolbar)

        tv_right_title.text = comicName

        hideLayout()

        setToolBar(ac_toolbar, mCurrRequestNewChapterBean.name)

        rv_list.setITouchCallBack {
            if (ll_right_layout.translationX == 0f)
                switchRightMenu()
            else
                switchBAndTMenu()
        }
        rv_list.addOnScrollListener(onScrollListener)
        //监听集数的返回
        mViewModel.mPerViewResponse.observe(this, Observer {
            hideLoading()
            when (rv_list.adapter) {
                null -> {
                    mComicPreAdapter = ComicPreAdapter(it.image_list)
                    //mComicPreAdapter?.setPreLoadNumber(6)
                    val layoutManager = if (isHorizontal) {
                        PreCacheLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
                    } else {
                        PreCacheLayoutManager(this)
                    }
                    rv_list.layoutManager = layoutManager
                    mComicPreAdapter?.bindToRecyclerView(rv_list)
                    mComicPreAdapter?.setEnableLoadMore(true)
                    mComicPreAdapter?.setOnLoadMoreListener(this, rv_list)
                    //跳转到最近阅读的位置
                    if (it.position != 0) {
                        rv_list.scrollToPosition(it.position)
                        (rv_list.layoutManager as LinearLayoutManager)
                            .scrollToPositionWithOffset(it.position, 0)
                        updateCurrPagerProcess(
                            it.position,
                            it.image_list.size,
                            mCurrRequestNewChapterBean.name
                        )
                    } else {
                        updateCurrPagerProcess(
                            1,
                            it.image_list.size,
                            mCurrRequestNewChapterBean.name
                        )
                    }
                }
                else -> {
                    mComicPreAdapter?.apply {
                        //如果是加载更多的话就就添加data
                        if (isLoading) {
                            loadMoreComplete()
                            addData(it.image_list)
                        } else {
                            //如果是点击章节的话就设置新的数据源
                            setNewData(it.image_list)
                            rv_list.scrollToPosition(0)
                            (rv_list.layoutManager as LinearLayoutManager)
                                .scrollToPositionWithOffset(0, 0)
                            updateCurrPagerProcess(
                                1,
                                it.image_list.size,
                                mCurrRequestNewChapterBean.name
                            )
                        }
                    }
                }
            }
        })
        sb_bar.setOnSeekBarChangeListener(this)
        tv_menu.setOnClickListener(this)
        tv_brightness.setOnClickListener(this)
        tv_switch_module.setOnClickListener(this)
        request(true)
    }


    private val onScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                Logger.e("-- SCROLL_STATE_IDLE")
                val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager
                val findFirstVisibleItemPosition =
                    linearLayoutManager.findFirstVisibleItemPosition()

                mComicPreAdapter?.getItem(findFirstVisibleItemPosition)?.also {
                    //获取章节id对应的position位置
                    mChapterListPosition[it.chapter_id]?.apply {
                        //如果不在这个集合里面说明需要保存阅读记录
                        if (mSaveChapterList[this] == null) {
                            updateRecordAndUi(this, it.chapter_id, it.chapterName, it.type)
                            mSaveChapterList.put(this, it.chapter_id)
                        }
                    }
                    //保存阅读记录
                    mViewModel.saveReadPosition(it.chapter_id, it.listIndex)
                    updateCurrPagerProcess(it.listIndex, it.listSize, it.chapterName)
                    //设置标题
                    setToolBarTitle(ac_toolbar, it.chapterName)
                }
            }
        }
    }

    /**
     * 更新当前右下角最新集数以及更新seekBar进度
     *
     */
    private fun updateCurrPagerProcess(index: Int, size: Int, title: String) {
        val format = String.format(
            getString(com.lai.comicmtc_v2.R.string.current_set_number),
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
            ViewCompat.animate(ll_right_layout).translationX(0f).duration = 300
            //跳转到最近阅读的章节位置
            mAllChapterList?.indexOf(mCurrRequestNewChapterBean)?.apply {
                if (this != -1) {
                    rv_right_list.scrollToPosition(this)
                    (rv_right_list.layoutManager as LinearLayoutManager)
                        .scrollToPositionWithOffset(this, 0)
                }
            }
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
            R.id.tv_switch_module -> {
                if (ll_bottom.translationY == 0f) {
                    switchBAndTMenu()
                }
                rv_list.layoutManager?.apply {
                    if (canScrollVertically()) {
                        isHorizontal = true
                        rv_list.layoutManager = LinearLayoutManager(
                            this@ComicPreViewActivity,
                            LinearLayoutManager.HORIZONTAL,
                            false
                        )
                        tv_switch_module.text = getString(R.string.model_vertical)
                    } else {
                        isHorizontal = false
                        rv_list.layoutManager = LinearLayoutManager(
                            this@ComicPreViewActivity,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                        tv_switch_module.text = getString(R.string.model_horizontal)
                    }
                }
            }
            R.id.tv_brightness -> {
                if (ll_bottom.translationY == 0f) {
                    switchBAndTMenu()
                }
                if (isNightModel) {
                    ViewUtils.changeAppBrightness(this, -1)
                    tv_brightness.text = getString(R.string.brightness_night)
                } else {
                    ViewUtils.changeAppBrightness(this, 50)
                    tv_brightness.text = getString(R.string.brightness_system)
                }
                isNightModel = !isNightModel
            }
        }
    }

    /**
     * 设置配置的信息
     */
    private fun initConfigInfoByUi() {
        if (isNightModel) {
            ViewUtils.changeAppBrightness(this, 50)
            tv_brightness.text = getString(R.string.brightness_system)
        } else {
            tv_brightness.text = getString(R.string.brightness_night)
        }
        if (isHorizontal) {
            tv_switch_module.text = getString(R.string.model_vertical)
        } else {
            tv_switch_module.text = getString(R.string.model_horizontal)

        }
        val adapter = ChapterAdapter(mAllChapterList!!, R.layout.item_chapter_right)
        adapter.onItemChildClickListener = this
        rv_right_list.layoutManager = LinearLayoutManager(this)
        adapter.bindToRecyclerView(rv_right_list)
    }

    override fun onLoadMoreRequested() {
        //加载更多。默认不保存阅读记录，因为有预加载不适合保存
        mAllChapterList?.indexOf(mCurrRequestNewChapterBean)?.also { position ->
            requestMore(position + 1, false)
        }
    }

    private fun requestMore(position: Int, isSaveDb: Boolean) {
        if (position != -1 && position <= mAllChapterList!!.size) {
            val chapterBean = mAllChapterList?.get(position)!!
            if (chapterBean.type == "3") {
                mComicPreAdapter?.apply {
                    if (isLoading) {
                        mComicPreAdapter?.loadMoreEnd()
                    }
                }
                toast(getString(R.string.no_support_vip_tip))
                return
            }

            mCurrRequestNewChapterBean = chapterBean
            mViewModel.setCurrChapterInfo(mCurrRequestNewChapterBean)
            mChapterListPosition[mCurrRequestNewChapterBean.chapter_id] = position
            //保存阅读记录,并且更新右边章节的阅读状态
            if (isSaveDb && !mCurrRequestNewChapterBean.isRead) {
                updateRecordAndUi(
                    position, mCurrRequestNewChapterBean.chapter_id,
                    mCurrRequestNewChapterBean.name, mCurrRequestNewChapterBean.type
                )
                //保存阅读记录
                mSaveChapterList.put(position, chapterBean.chapter_id)
            }

            request()
        } else {
            mComicPreAdapter?.apply {
                if (isLoading) {
                    mComicPreAdapter?.loadMoreEnd()
                }
            }
            toast(getString(R.string.last_tip))
        }
    }


    /**
     * 更新阅读记录并且列表UI状态
     */
    private fun updateRecordAndUi(
        position: Int,
        chapterId: String,
        chapterName: String,
        type: String
    ) {
        if (mViewModel.saveReadChapter(comicId, comicName, chapterId, chapterName, type)) {
            getAdapter<ChapterAdapter>(rv_right_list)?.apply {
                getItem(position)?.isRead = true
                notifyItemChanged(position)
                Logger.e("-- 更新位置$position name $chapterName")
            }
        }
    }

    override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        adapter?.getItem(position)?.apply {
            this as ComicDetailResponse.ChapterListBean
            if (type == "3") {
                toast(getString(com.lai.comicmtc_v2.R.string.no_support_vip_tip))
            } else {
                requestMore(position, !isRead)
            }
        }
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        seekBar?.apply {
            val index = if (progress == 0) {
                1
            } else progress
            //更新右下角
            updateCurrPagerProcess(index, max, mCurrRequestNewChapterBean.name)
            rv_list.scrollToPosition(progress)
        }
    }


}
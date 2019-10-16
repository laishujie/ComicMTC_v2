package com.lai.comicmtc_v2.ui.search

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.gyf.barlibrary.ImmersionBar
import com.lai.comicmtc_v2.R
import com.lai.comicmtc_v2.ui.comm.BaseVMActivity
import com.lai.comicmtc_v2.ui.comm.SpaceItemDecoration
import com.lai.comicmtc_v2.ui.detail.ComicDetailActivity
import com.lai.comicmtc_v2.ui.widget.FlowLayoutManager
import com.lai.comicmtc_v2.utils.DisplayUtils
import kotlinx.android.synthetic.main.activity_search.*

/**
 *
 * @author  Lai
 *
 * @time 2019/10/15 15:01
 * @describe describe
 *
 */
class SearchActivity : BaseVMActivity(), BaseQuickAdapter.OnItemChildClickListener,
    BaseQuickAdapter.RequestLoadMoreListener {


    private val mViewModel by lazy { createViewModel<SearchViewModel>() }

    private var mSearchStr: String = ""

    private var mCurrPager = 1

    override fun getLayout(): Int {
        return R.layout.activity_search
    }

    companion object {
        fun openActivity(activity: AppCompatActivity) {
            val intent = Intent(activity, SearchActivity::class.java)
            activity.startActivity(intent)
        }
    }


    override fun init(savedInstanceState: Bundle?) {
        ImmersionBar.setStatusBarView(this, view_status)

        mViewModel.mSearchBean.observe(this, Observer {
            ed_search.hint = it.defaultSearch
            val adapter = HotTagAdapter(it.hotItems)
            adapter.onItemChildClickListener = this
            adapter.bindToRecyclerView(rv_hot_list)
            rv_hot_list.addItemDecoration(SpaceItemDecoration(DisplayUtils.dp2px(5f)))
            rv_hot_list.layoutManager = FlowLayoutManager()
        })
        mViewModel.mHistoryBean.observe(this, Observer {
            if (it.isNotEmpty()) {
                tv_history.visibility = View.VISIBLE
                val adapter = HistoryAdapter(it)
                adapter.onItemChildClickListener = this
                adapter.bindToRecyclerView(rv_history_list)
                rv_history_list.layoutManager = LinearLayoutManager(this)
            } else {
                tv_history.visibility = View.INVISIBLE
            }
        })

        ed_search.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val text = if (TextUtils.isEmpty(ed_search.text)) {
                    ed_search.hint
                } else ed_search.text
                if (TextUtils.isEmpty(text)) {
                    toast("请输入内容")
                } else {
                    ns_layout.visibility = View.GONE
                    mSearchStr = text.toString()
                    ed_search.setText(mSearchStr)
                    ed_search.setSelection(mSearchStr.length)
                    mCurrPager = 1
                    showLoading()
                    rv_search.adapter = null
                    mViewModel.getSearchResult(mSearchStr, mCurrPager)
                }
                return@setOnEditorActionListener true
            }
            false
        }
        iv_back.setOnClickListener {
            finish()
        }
        ed_search.onTextCountChanged { count ->
            val isZone = count == 0
            ns_layout.visibility = if (isZone) View.VISIBLE else View.GONE
            tv_search_result.visibility = if (isZone) View.GONE else View.VISIBLE
            rv_search.visibility = if (isZone) View.GONE else View.VISIBLE
        }


        mViewModel.mSearchResult.observe(this, Observer {
            hideLoading()
            tv_search_result.visibility = View.VISIBLE
            rv_search.visibility = View.VISIBLE
            tv_search_result.text =
                String.format(getString(R.string.search_info_tip), mSearchStr, it.comicNum)
            if (rv_search.adapter == null) {
                val adapter = SearchAdapter(it.comics)
                adapter.onItemChildClickListener = this
                rv_search.layoutManager = LinearLayoutManager(this)
                adapter.enableLoadMoreEndClick(true)
                adapter.bindToRecyclerView(rv_search)
                adapter.setOnLoadMoreListener(this, rv_search)
            } else {
                getAdapter<SearchAdapter>(rv_search)?.apply {
                    if (it.isHasMore) {
                        loadMoreComplete()
                    } else {
                        loadMoreEnd()
                    }
                    if (it.comics.isNotEmpty())
                        addData(it.comics)
                }
            }
        })
        mViewModel.getSearchHot()
        mViewModel.getHistory()
    }

    override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        when (adapter) {
            is HotTagAdapter -> {
                adapter.getItem(position)?.apply {
                    ComicDetailActivity.openActivity(
                        this@SearchActivity,
                        comic_id
                    )
                }
            }
            is HistoryAdapter -> {
                adapter.getItem(position)?.apply {
                    if (view?.id == R.id.iv_delete) {
                        if (delete() > 0)
                            adapter.remove(position)
                    } else {
                        ComicDetailActivity.openActivity(
                            this@SearchActivity,
                            comicId
                        )
                    }
                }
            }
            is SearchAdapter->{
                adapter.getItem(position)?.apply {
                    ComicDetailActivity.openActivity(
                        this@SearchActivity,
                        comicId.toString()
                    )
                }
            }
        }
    }

    override fun onLoadMoreRequested() {
        mCurrPager++
        mViewModel.getSearchResult(mSearchStr, mCurrPager)
    }


    private fun EditText.onTextCountChanged(afterTextChanged: (Int) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                afterTextChanged.invoke(p3)
            }

            override fun afterTextChanged(editable: Editable?) {
            }
        })
    }

}
package com.lai.comicmtc_v2.ui.bookshelf

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.gyf.barlibrary.ImmersionBar
import com.lai.comicmtc_v2.R
import com.lai.comicmtc_v2.ui.comm.BaseVMFragment
import com.lai.comicmtc_v2.ui.detail.ComicDetailActivity
import com.orhanobut.logger.Logger
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import kotlinx.android.synthetic.main.fragment_bookshelf.*

/**
 *
 * @author  Lai
 *
 * @time 2019/9/22 17:53
 * @describe describe
 *
 */
class BookShelfFragment : BaseVMFragment(), OnRefreshListener,
    BaseQuickAdapter.OnItemChildClickListener {



    private val mViewModel by lazy { createViewModel<BookShelfViewModel>() }

    override fun getLayoutId(): Int {
        return R.layout.fragment_bookshelf
    }

    override fun init(savedInstanceState: Bundle?) {
        Logger.e("-- SortFragment ")
        refreshLayout.setEnableLoadMore(false)
        refreshLayout.setOnRefreshListener(this)
        ImmersionBar.setTitleBar(_mActivity, tv_title)
        mViewModel.mCollection.observe(this, Observer {
            val text = String.format(getString(R.string.bookshelf), it.size)
            tv_title.text = text
            if (rv_list.adapter == null) {
                val adapter = BookShelfAdapter(it)
                rv_list.addItemDecoration(BookShelfDecoration())
                adapter.bindToRecyclerView(rv_list)
                adapter.onItemChildClickListener = this
                rv_list.layoutManager = GridLayoutManager(_mActivity, 3)
            } else {
                val adapter = rv_list.adapter as BookShelfAdapter
                adapter.setNewData(it)
            }
            refreshLayout.finishRefresh()
        })
        mViewModel.getAllCollection()
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        mViewModel.getAllCollection()
    }

    override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        adapter?.apply {
            this as BookShelfAdapter
            getItem(position)?.apply {
                ComicDetailActivity.openActivity(_mActivity,comicId)
            }
        }
    }

}
package com.lai.comicmtc_v2.ui.comm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import me.yokeyword.fragmentation.SupportFragment

/**
 *
 * @author  Lai
 *
 * @time 2019/9/22 16:44
 * @describe describe
 *
 */
abstract class BaseFragment : SupportFragment(), IBaseView {

    //是否首次加载
    private var isFirstLoad = true


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        onCreateView(savedInstanceState)
        return inflater.inflate(getLayoutId(), container, false)
    }

    open fun onCreateView(savedInstanceState: Bundle?) {

    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        super.onLazyInitView(savedInstanceState)
        isFirstLoad = false
        init(savedInstanceState)
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!isFirstLoad) {
            if (!hidden) {
                onFragmentVisible()
            }
        }
    }



    /**
     * fragment可见
     */
    open fun onFragmentVisible() {}


    /**
     * 获取当前Activity的UI布局
     *
     * @return 布局id
     */
    protected abstract fun getLayoutId(): Int

    //时间初始化方法
    protected abstract fun init(savedInstanceState: Bundle?)

    fun toast(str: String) {
        Toast.makeText(_mActivity, str, Toast.LENGTH_LONG).show()
    }


    override fun showLoading() {
        if (_mActivity is BaseActivity) {
            (_mActivity as BaseActivity).showLoading()
        }
    }

    override fun hideLoading() {
        if (_mActivity is BaseActivity) {
            (_mActivity as BaseActivity).hideLoading()
        }
    }
}
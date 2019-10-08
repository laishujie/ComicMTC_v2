package com.lai.comicmtc_v2.ui.sort

import android.os.Bundle
import com.lai.comicmtc_v2.R
import com.lai.comicmtc_v2.ui.comm.BaseVMFragment
import com.orhanobut.logger.Logger

/**
 *
 * @author  Lai
 *
 * @time 2019/9/22 17:53
 * @describe describe
 *
 */
class SortFragment :BaseVMFragment(){
    override fun getLayoutId(): Int {
        return R.layout.fragment_sort
    }

    override fun init(savedInstanceState: Bundle?) {
        Logger.e("-- SortFragment ")

    }

}
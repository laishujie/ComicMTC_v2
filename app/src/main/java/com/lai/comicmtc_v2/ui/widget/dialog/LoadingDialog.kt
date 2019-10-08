package com.lai.comicmtc_v2.ui.widget.dialog

import android.content.Context
import android.view.View
import com.lai.comicmtc_v2.R
import kotlinx.android.synthetic.main.layout_loading.*

/**
 *
 * @author  Lai
 *
 * @time 2019/9/29 17:27
 * @describe describe
 *
 */
class LoadingDialog(context: Context) : BaseDialog(context,R.style.LoadingDialog) {
    override fun getLayout(): Int {
        return R.layout.layout_loading
    }

    override fun init(view: View) {

    }

    override fun dismiss() {
        animation_view.cancelAnimation()
        super.dismiss()
    }


}
package com.lai.comicmtc_v2.ui.widget.dialog

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatDialog
import com.lai.comicmtc_v2.R


/**
 * @author Lai
 * @time 2018/10/12 13:59
 * @Description
 */
abstract class BaseDialog(context: Context,theme: Int = R.style.Theme_AppCompat_Dialog) : AppCompatDialog(context,theme) {
    abstract fun getLayout(): Int
    abstract fun init(view: View)

    //通用的确定click
    var mCommitClick: (() -> Unit?)? = null

    var mCloseBtnCallback: (() -> Unit?)? = null

    fun commitClick(clickListener: (() -> Unit?)): BaseDialog {
        mCommitClick = clickListener
        return this
    }

    fun closeBtnCallback(clickListener: (() -> Unit?)): BaseDialog {
        mCloseBtnCallback = clickListener
        return this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getLayout() != 0) {
            val view = LayoutInflater.from(context).inflate(getLayout(), null)
            setContentView(view)
            setWindowSize()
            init(view)
            initDefaultClick()
        }
    }

    private fun initDefaultClick() {
        findViewById<View>(R.id.dialog_commit_btn)?.setOnClickListener {
            mCommitClick?.invoke()
            dismiss()
        }
        findViewById<View>(R.id.dialog_close_btn)?.setOnClickListener {
            mCloseBtnCallback?.invoke()
            dismiss()
        }
    }

    /**
     * 设置窗口尺寸和位置
     */
    open fun setWindowSize() {
        val dialogWindow = this.window
        dialogWindow!!.setBackgroundDrawableResource(android.R.color.transparent)//设置透明
        val lp = dialogWindow.attributes
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        lp.gravity = Gravity.CENTER
        lp.y = getDistanceY()
        dialogWindow.attributes = lp
    }

    fun showDialog() {
        if (!isShowing) {
            show()
        }
    }

    fun hideDialog() {
        if (isShowing) {
            dismiss()
        }
    }

    /**
     * 弹窗Y轴偏移量
     */
    open fun getDistanceY(): Int {
        return 0
    }


}
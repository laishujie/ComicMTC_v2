package com.lai.comicmtc_v2.utils

import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.annotation.DrawableRes
import com.gyf.barlibrary.ImmersionBar



/**
 *
 * @author  Lai
 *
 * @time 2019/9/25 22:15
 * @describe describe
 *
 */
object ViewUtils {
    fun setDrawRight(context: Context, @DrawableRes res: Int, mTextView: TextView) {
        val drawableRight = context.resources.getDrawable(res)
        mTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, drawableRight, null)
    }

    fun setDrawLeft(context: Context, @DrawableRes res: Int, mTextView: TextView?) {
        val drawableLeft = context.resources.getDrawable(res)
        mTextView?.setCompoundDrawablesWithIntrinsicBounds(drawableLeft, null, null, null)
    }

    fun clearDraw(textView: TextView?) {
        textView?.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)
    }

    fun setBarHeight(activity: Activity, view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val params = view.layoutParams
            params.height += ImmersionBar.getStatusBarHeight(activity)
            view.layoutParams = params
        }
    }

    /**
     * 获取控件的高度
     */
    fun getViewMeasuredHeight(view: View): Int {
        calculateViewMeasure(view)
        return view.measuredHeight
    }

    /**
     * 获取控件的宽度
     */
    fun getViewMeasuredWidth(view: View): Int {
        calculateViewMeasure(view)
        return view.measuredWidth
    }

    /**
     * 测量控件的尺寸
     */
    private fun calculateViewMeasure(view: View) {
        val w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        val h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)

        view.measure(w, h)
    }

    // 根据亮度值修改当前window亮度
    fun changeAppBrightness(context: Context, brightness: Int) {
        val window = (context as Activity).window
        val lp = window.attributes
        if (brightness == -1) {
            lp.screenBrightness = WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_NONE
        } else {
            lp.screenBrightness = (if (brightness <= 0) 1 else brightness) / 255f
        }
        window.attributes = lp
    }

}
package com.lai.comicmtc_v2.ui.comm

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import com.google.android.material.appbar.AppBarLayout
import com.gyf.barlibrary.ImmersionBar
import com.lai.comicmtc_v2.R
import com.lai.comicmtc_v2.utils.ArithHelper
import com.lai.comicmtc_v2.utils.DisplayUtils
import java.lang.Math.abs

/**
 *
 * @author  Lai
 *
 * @time 2019/9/24 18:00
 * @describe describe
 *
 */
class RootIconBehavior : CoordinatorLayout.Behavior<ConstraintLayout> {
    constructor() : super()
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    var totalScrollRange = 0f
    var layoutHeightDistance = 0
    var layoutWidthDistance = 0
    var heightRatio = 0f
    var widthRatio = 0f
    var defaultMargin = 0
    var iconDefaultStytle = true

    //切换样式零界点
    private var threshold = 0f
    private var mTv1: TextView? = null
    private var mTv2: TextView? = null
    private var mTv3: TextView? = null
    private var mTv4: TextView? = null

    private var mLayout1: View? = null
    private var mLayout2: View? = null
    private var mLayout3: View? = null
    private var mLayout4: View? = null

    private var mIv1: ImageView? = null
    private var mIv2: ImageView? = null
    private var mIv3: ImageView? = null
    private var mIv4: ImageView? = null

    private var rv1Position = 0
    private var rv2Position = 0
    private var rv3Position = 0
    private var rv4Position = 0

    private var mSearchView: View? = null

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: ConstraintLayout,
        dependency: View
    ): Boolean {
        if (dependency is AppBarLayout) {
            if (mTv1 == null) {
                mTv1 = child.findViewById(R.id.tv_1)
                mTv2 = child.findViewById(R.id.tv_2)
                mTv3 = child.findViewById(R.id.tv_3)
                mTv4 = child.findViewById(R.id.tv_4)
                mIv1 = child.findViewById(R.id.iv_1)
                mIv2 = child.findViewById(R.id.iv_2)
                mIv3 = child.findViewById(R.id.iv_3)
                mIv4 = child.findViewById(R.id.iv_4)
                mSearchView = child.findViewById(R.id.tv_search)
                mLayout1 = child.findViewById(R.id.top_layout_1)
                mLayout2 = child.findViewById(R.id.top_layout_2)
                mLayout3 = child.findViewById(R.id.top_layout_3)
                mLayout4 = child.findViewById(R.id.top_layout_4)
                mIv1?.post {
                    val marginEnd = DisplayUtils.dp2px(10f)
                    val imageWidth = mIv1!!.width
                    rv4Position = getImageViewByEnd(mLayout4, mTv4) - marginEnd
                    rv3Position = getImageViewByEnd(mLayout3, mTv3) - marginEnd * 2 - imageWidth
                    rv2Position = getImageViewByEnd(mLayout2, mTv2) - marginEnd * 3 - imageWidth * 2
                    rv1Position = getImageViewByEnd(mLayout1, mTv1) - marginEnd * 4 - imageWidth * 3
                    defaultMargin =
                        (mSearchView!!.layoutParams as ConstraintLayout.LayoutParams).marginEnd
                    layoutWidthDistance =
                        DisplayUtils.getScreenWidth() - (rv1Position + mLayout1!!.right - defaultMargin - imageWidth)
                    totalScrollRange = dependency.totalScrollRange.toFloat()-
                            ImmersionBar.getStatusBarHeight(dependency.context as Activity)
                    widthRatio = ArithHelper.div(layoutWidthDistance.toFloat(), totalScrollRange)

                    layoutHeightDistance = mLayout1!!.top - mSearchView!!.top
                    heightRatio = ArithHelper.div(layoutHeightDistance.toFloat(), totalScrollRange)
                    threshold = dependency.totalScrollRange / 1.5f
                }
            }
        }

        return dependency is AppBarLayout
    }


    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: ConstraintLayout,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        return axes and ViewCompat.SCROLL_AXIS_VERTICAL != 0//判断是否竖直滚动
    }


    /**
     * 获取imageview距离右边的距离是多少
     */
    private fun getImageViewByEnd(layout: View?, textView: TextView?): Int {
        return DisplayUtils.getScreenWidth() - layout!!.right + textView!!.width
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: ConstraintLayout,
        dependency: View
    ): Boolean {
        if (dependency is AppBarLayout) {

            if (layoutWidthDistance != 0) {

                val dy = abs(ArithHelper.mul(dependency.y, heightRatio))

                if (rv1Position != 0) {
                    val ro = ArithHelper.div(rv1Position.toFloat(), totalScrollRange)
                    val tx = abs(ArithHelper.mul(dependency.y, ro))
                    mLayout1?.translationX = tx
                }

                if (rv2Position != 0) {
                    val ro = ArithHelper.div(rv2Position.toFloat(), totalScrollRange)
                    val tx = abs(ArithHelper.mul(dependency.y, ro))
                    mLayout2?.translationX = tx
                }

                if (rv3Position != 0) {
                    val ro = ArithHelper.div(rv3Position.toFloat(), totalScrollRange)
                    val tx = abs(ArithHelper.mul(dependency.y, ro))
                    mLayout3?.translationX = tx
                }

                if (rv4Position != 0) {
                    val ro = ArithHelper.div(rv4Position.toFloat(), totalScrollRange)
                    val tx = abs(ArithHelper.mul(dependency.y, ro))
                    mLayout4?.translationX = tx
                }

                if (dy <= layoutHeightDistance) {
                    mLayout1?.translationY = -dy
                    mLayout2?.translationY = -dy
                    mLayout3?.translationY = -dy
                    mLayout4?.translationY = -dy
                }

                val absY = abs(dependency.y)

                val dw = abs(ArithHelper.mul(dependency.y, widthRatio))
                mSearchView?.layoutParams?.apply {
                    this as ConstraintLayout.LayoutParams
                    marginEnd = dw.toInt() +defaultMargin
                    mSearchView?.layoutParams = this
                }

                if (absY >= threshold) {
                    //更换icon
                    if (iconDefaultStytle) {
                        switchStyle(
                            mIv1,
                            R.mipmap.icon_discover_column_rank_white,
                            R.mipmap.icon_discover_column_rank_green
                        )
                        switchStyle(
                            mIv2,
                            R.mipmap.icon_discover_column_classify_white,
                            R.mipmap.icon_discover_column_classify_green
                        )
                        switchStyle(
                            mIv3,
                            R.mipmap.icon_discover_column_vip_white,
                            R.mipmap.icon_discover_column_vip_green
                        )
                        switchStyle(
                            mIv4,
                            R.mipmap.icon_discover_column_subscribe_white,
                            R.mipmap.icon_discover_column_subscribe_green
                        )
                        iconDefaultStytle = !iconDefaultStytle
                    }
                } else {
                    val percent = 1 - ArithHelper.div(absY, threshold)
                    mTv1?.alpha = percent
                    mTv2?.alpha = percent
                    mTv3?.alpha = percent
                    mTv4?.alpha = percent

                    if (!iconDefaultStytle) {
                        switchStyle(
                            mIv1,
                            R.mipmap.icon_discover_column_rank_white,
                            R.mipmap.icon_discover_column_rank_green
                        )
                        switchStyle(
                            mIv2,
                            R.mipmap.icon_discover_column_classify_white,
                            R.mipmap.icon_discover_column_classify_green
                        )
                        switchStyle(
                            mIv3,
                            R.mipmap.icon_discover_column_vip_white,
                            R.mipmap.icon_discover_column_vip_green
                        )
                        switchStyle(
                            mIv4,
                            R.mipmap.icon_discover_column_subscribe_white,
                            R.mipmap.icon_discover_column_subscribe_green
                        )
                        iconDefaultStytle = !iconDefaultStytle
                    }

                }


            }
        }
        return super.onDependentViewChanged(parent, child, dependency)
    }


    private fun switchStyle(imageView: ImageView?, defaultRes: Int, switchRes: Int) {
        imageView?.apply {
            if (iconDefaultStytle) {
                setBackgroundResource(R.drawable.shape_top_circle_bg)
                setImageResource(switchRes)
            } else {
                background = null
                setImageResource(defaultRes)
            }
        }

    }
}
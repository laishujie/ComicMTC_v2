package com.lai.comicmtc_v2.ui.widget

import android.content.Context
import android.graphics.BlurMaskFilter
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.ImageView
import com.lai.comicmtc_v2.utils.DisplayUtils



/**
 *
 * @author  Lai
 *
 * @time 2019/9/21 16:14
 * @describe describe
 *
 */
class BookView : ImageView {
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    private val mWhitePaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mBlackPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        mWhitePaint.strokeWidth = 20f
        mBlackPaint.strokeWidth = 5f
        mWhitePaint.maskFilter = BlurMaskFilter(10f, BlurMaskFilter.Blur.NORMAL)
        mWhitePaint.color = Color.WHITE
        mWhitePaint.alpha = 50

        mBlackPaint.maskFilter = BlurMaskFilter(15f, BlurMaskFilter.Blur.NORMAL)
        mBlackPaint.color = Color.BLACK
        //mBlackPaint.alpha = 100
    }



    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

       /* val sha = LinearGradient(DisplayUtils.dp2px(18f).toFloat(),0f,0f,height.toFloat()
        ,Color.WHITE,Color.WHITE,Shader.TileMode.CLAMP)
        mWhitePaint.shader = sha*/

        canvas?.drawLine(DisplayUtils.dp2px(9f).toFloat(), -50f, DisplayUtils.dp2px(9f).toFloat(), height.toFloat()+50, mWhitePaint)


        canvas?.drawLine(0f, 0f, 0f, height.toFloat(), mBlackPaint)
    }




}
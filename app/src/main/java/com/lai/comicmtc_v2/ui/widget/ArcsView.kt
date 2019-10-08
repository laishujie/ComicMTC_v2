package com.lai.comicmtc_v2.ui.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.lai.comicmtc_v2.R


/**
 *
 * @author  Lai
 *
 * @time 2019/9/23 16:33
 * @describe describe
 *
 */
class ArcsView : View {
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val mPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mLinePath: Path = Path()


    init {
        setLayerType(ImageView.LAYER_TYPE_SOFTWARE, null)
        mPaint.style = Paint.Style.FILL
        mPaint.isAntiAlias = true
        mPaint.color = ContextCompat.getColor(context, R.color.color_fafafa)
    }


    override fun onDraw(canvas: Canvas?) {
        mLinePath.moveTo(0f, height.toFloat())

        mLinePath.quadTo(
            width / 2f, 0f, width.toFloat(),
            height.toFloat()
        )
        canvas?.drawPath(mLinePath, mPaint)
    }


}
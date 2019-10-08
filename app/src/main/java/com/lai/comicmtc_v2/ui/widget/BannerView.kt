package com.lai.comicmtc_v2.ui.widget

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.TransformationUtils
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.transition.Transition


/**
 *
 * @author  Lai
 *
 * @time 2019/9/23 16:33
 * @describe describe
 *
 */
class BannerView : View {
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private val mPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mLinePath: Path = Path()
    private var mPorterDuffXfermode: PorterDuffXfermode? = null
    var viewTag: CustomViewTarget<BannerView, Bitmap>? = null

    private var mBitmap: Bitmap? = null


    fun setBitmap(bitmap: Bitmap) {
        mBitmap = bitmap
        invalidate()
    }

    init {
        setLayerType(ImageView.LAYER_TYPE_SOFTWARE, null)
        mPaint.style = Paint.Style.FILL
        //mPaint.color = Color.TRANSPARENT
        mPorterDuffXfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        viewTag = object : CustomViewTarget<BannerView, Bitmap>(this) {
            override fun onLoadFailed(errorDrawable: Drawable?) {

            }

            override fun onResourceCleared(placeholder: Drawable?) {

            }

            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                setBitmap(resource)
            }

        }
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mBitmap?.also {
            val width4 = width / 4f
            mLinePath.moveTo(0f, height.toFloat() / 1.2f)
            mLinePath.cubicTo(
                width4,
                height.toFloat(),
                width4 * 3,
                height.toFloat(),
                width.toFloat(),
                height.toFloat() / 1.2f
            )
            //mLinePath.quadTo(width.toFloat(), height.toFloat() / 1.2f, width.toFloat(), 0f)
            mLinePath.quadTo(width.toFloat(), 0f, width.toFloat(), 0f)
            mLinePath.quadTo(0f, 0f, 0f, 0f)
            canvas?.drawPath(mLinePath, mPaint)

            mPaint.xfermode = mPorterDuffXfermode
            canvas?.drawBitmap(TransformationUtils.centerCrop(Glide.get(context).bitmapPool,
                it,width,height), 0f, 0f, mPaint)
        }
    }


}
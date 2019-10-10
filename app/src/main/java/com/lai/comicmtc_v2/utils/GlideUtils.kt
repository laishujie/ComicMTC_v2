package com.lai.comicmtc_v2.utils

import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.target.Target
import com.lai.comicmtc_v2.R
import com.lai.comicmtc_v2.ui.comm.RoundedCornersTransformation

/**
 *
 * @author  Lai
 *
 * @time 2019/9/16 0:14
 * @describe describe
 *
 */
object GlideUtils {


    fun loadImage(
        context: Context,
        url: String?,
        roundingRadius: Float = 8f,
        placeholder: Int,
        error: Int,
        width: Int = Target.SIZE_ORIGINAL,
        height: Int = Target.SIZE_ORIGINAL,
        viewTag: CustomViewTarget<ImageView, Bitmap>
    ) {
        val roundedCorners = RoundedCornersTransformation(DisplayUtils.dp2px(roundingRadius), 0)
        val options = RequestOptions()
            .transform(CenterCrop(), roundedCorners)
            .placeholder(placeholder)
            .error(error)
            .override(width, height)
        Glide.with(context).asBitmap().load(url).apply(options)
            .into(viewTag)
    }


    fun loadImage(
        context: Context,
        url: String?,
        view: ImageView,
        roundingRadius: Float = 8f,
        width: Int = Target.SIZE_ORIGINAL,
        height: Int = Target.SIZE_ORIGINAL
    ) {
        val roundedCorners = RoundedCornersTransformation(DisplayUtils.dp2px(roundingRadius), 0)
        val options = RequestOptions()
            .transform(CenterCrop(), roundedCorners)
            .placeholder(R.color.color_F6F5F7)
            .error(R.color.color_F6F5F7)
            .override(width, height)
        Glide.with(context).load(url).apply(options)
            .into(view)
    }


}
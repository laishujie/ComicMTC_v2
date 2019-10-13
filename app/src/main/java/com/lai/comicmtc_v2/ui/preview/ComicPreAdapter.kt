package com.lai.comicmtc_v2.ui.preview

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.transition.Transition
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lai.comicmtc_v2.R
import com.lai.comicmtc_v2.bean.preview.ComicPreViewResponse
import com.lai.comicmtc_v2.utils.ArithHelper
import com.lai.comicmtc_v2.utils.DisplayUtils
import com.lai.comicmtc_v2.utils.GlideUtils
import kotlin.math.roundToInt


/**
 *
 * @author  Lai
 *
 * @time 2019/10/4 15:23
 * @describe 预览
 *
 */
class ComicPreAdapter(data: List<ComicPreViewResponse.ImageListBean>) :
        BaseQuickAdapter<ComicPreViewResponse.ImageListBean, BaseViewHolder>(R.layout.item_preview, data) {


    private val screenWidth = DisplayUtils.getScreenWidth()


    override fun convert(helper: BaseViewHolder?, item: ComicPreViewResponse.ImageListBean?) {
        helper?.apply {
            item?.also {
                //根据服务起返回的图片宽高等比例固定宽度，高度自适应放大
                val imageView = getView<ImageView>(R.id.iv_cover)
                val scale = ArithHelper.div(screenWidth, it.width)
                val vh = (it.height * scale).roundToInt()
                val layoutParams = imageView.layoutParams
                layoutParams.height = vh
                imageView.layoutParams = layoutParams
                setText(R.id.tv_position,it.listIndex.toString())
                setGone(R.id.tv_position, true)
                GlideUtils.loadImage(mContext, it.img50, 0f, R.color.black, R.color.black, it.width, it.height,
                        object : CustomViewTarget<ImageView, Bitmap>(imageView) {
                            override fun onLoadFailed(errorDrawable: Drawable?) {

                            }

                            override fun onResourceCleared(placeholder: Drawable?) {
                            }

                            override fun onResourceReady(
                                    resource: Bitmap,
                                    transition: Transition<in Bitmap>?
                            ) {
                                setGone(R.id.tv_position, false)
                                imageView.setImageBitmap(resource)
                            }

                            override fun onResourceLoading(placeholder: Drawable?) {
                                super.onResourceLoading(placeholder)
                                imageView?.setImageDrawable(placeholder)
                            }

                        }
                )
            }
        }
    }

    override fun onViewRecycled(holder: BaseViewHolder) {
        super.onViewRecycled(holder)
        holder.getView<ImageView>(R.id.iv_cover)?.apply {
            Glide.with(mContext).clear(this)
        }
    }

}
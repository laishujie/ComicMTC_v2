package com.lai.comicmtc_v2.ui.preview

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
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
 * @describe describe
 *
 */
class ComicPreAdapter(data: List<ComicPreViewResponse.ImageListBean>) :
    BaseQuickAdapter<ComicPreViewResponse.ImageListBean, BaseViewHolder>(
        com.lai.comicmtc_v2.R.layout.item_preview,
        data
    ) {


    private val screenWidth = DisplayUtils.getScreenWidth()


    override fun convert(helper: BaseViewHolder?, item: ComicPreViewResponse.ImageListBean?) {
        helper?.apply {
            item?.also {
                //根据服务起返回的图片宽高等比例固定宽度，高度自适应放大
                val imageView = getView<ImageView>(com.lai.comicmtc_v2.R.id.iv_cover)
                val scale = ArithHelper.div(screenWidth, it.width)
                val vh = (it.height * scale).roundToInt()
                val layoutParams = imageView.layoutParams
                layoutParams.height = vh
                imageView.layoutParams = layoutParams

                GlideUtils.loadImage(
                    mContext, it.img50, imageView,
                    0f,
                    com.lai.comicmtc_v2.R.color.black, com.lai.comicmtc_v2.R.color.black,it.width,it.height
                )
            }
        }
    }

    override fun onViewRecycled(holder: BaseViewHolder) {
        super.onViewRecycled(holder)
        holder.getView<ImageView>(com.lai.comicmtc_v2.R.id.iv_cover)?.apply {
            Glide.with(mContext).clear(this)
        }
    }

}
package com.lai.comicmtc_v2.utils;

import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.View;


/**
 * Created by AA on 2017/1/9.
 * DP/PX数值转换工具类
 */
public class DisplayUtils {

    /**
     * 获取屏幕宽高信息
     *
     * @return
     */
    public static Point getScreenMetrics() {
        DisplayMetrics dm = Resources.getSystem().getDisplayMetrics();
        return new Point(dm.widthPixels, dm.heightPixels);
    }

    /**
     * 获取屏幕宽度
     *
     * @return
     */
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight() {
        int result = 0;
        int resourceId = Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = Resources.getSystem().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    /**
     * 获取导航栏高度
     */
    public static int getNavigationBarHeight() {
        int result = 0;
        int resourceId=Resources.getSystem().getIdentifier("navigation_bar_height","dimen","android");
        if(resourceId>0){
            result =  Resources.getSystem().getDimensionPixelSize(resourceId);
        }
        return result;
    }


    /**
     * 获取bitmap Density
     *
     * @return bitmapDensity
     */
    public static int getBitmapDensity() {
        int densityDpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        if (densityDpi <= DisplayMetrics.DENSITY_LOW) {
            return DisplayMetrics.DENSITY_LOW;
        } else if (densityDpi <= DisplayMetrics.DENSITY_MEDIUM) {
            return DisplayMetrics.DENSITY_MEDIUM;
        } else if (densityDpi <= DisplayMetrics.DENSITY_HIGH) {
            return DisplayMetrics.DENSITY_HIGH;
        } else if (densityDpi <= DisplayMetrics.DENSITY_XHIGH) {
            return DisplayMetrics.DENSITY_XHIGH;
        } else if (densityDpi <= DisplayMetrics.DENSITY_400) {
            return DisplayMetrics.DENSITY_XHIGH;
        } else {
            return DisplayMetrics.DENSITY_XXHIGH;
        }
    }

    /**
     * 获取屏幕高度
     *
     * @return
     */
    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int px2dp(float pxValue) {
        float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5F);
    }

    public static int dp2px(float dipValue) {
        float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5F);
    }

    public static int px2sp(float pxValue) {
        float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5F);
    }

    public static float px2spToFloat(float pxValue) {
        float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (pxValue / fontScale + 0.5F);
    }

    public static int sp2px(float spValue) {
        float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5F);
    }


    /**
     * 获取View的宽高
     *
     * @param view
     * @return
     */
    public static int[] getViewSize(View view) {
        int size[] = new int[2];
        int width = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int height = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        view.measure(width, height);
        size[0] = view.getMeasuredWidth();
        size[1] = view.getMeasuredHeight();
        return size;
    }
}

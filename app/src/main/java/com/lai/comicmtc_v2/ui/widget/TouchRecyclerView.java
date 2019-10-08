package com.lai.comicmtc_v2.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Lai
 * @time 2018/1/29 21:40
 * @describe 触摸相关的RecyclerView.
 * 具体的作用：只要点击事件。滑动的话不算
 */

public class TouchRecyclerView extends RecyclerView {

    private int touchSlop;
    private float startX = -1;
    private float startY = -1;


    public void setITouchCallBack(ITouchCallBack IMiddleCallBack) {
        mIMiddleCallBack = IMiddleCallBack;
    }

    private ITouchCallBack mIMiddleCallBack;

    public TouchRecyclerView(Context context) {
        this(context, null);
    }

    public TouchRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TouchRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();

        //addOnScrollListener(new ImageAutoLoadScrollListener());
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                startY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                if (Math.abs(event.getX() - startX) > touchSlop)
                    startX = -1;
                if (Math.abs(event.getY() - startY) > touchSlop)
                    startX = -1;

                if (startX != -1) {
                    if (mIMiddleCallBack != null)
                        mIMiddleCallBack.click();
                }
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    public interface ITouchCallBack {
        void click();
    }
}

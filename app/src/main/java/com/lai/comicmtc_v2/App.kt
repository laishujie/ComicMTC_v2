package com.lai.comicmtc_v2

import android.app.Application
import android.content.ComponentCallbacks2
import android.content.Context
import android.util.Log
import com.bumptech.glide.Glide
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.LogStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import org.litepal.LitePal
import kotlin.properties.Delegates

class App : Application() {

    companion object {
        var CONTEXT: Context by Delegates.notNull()
    }

    //当前是否低内存
    var isLowMemory = false

    override fun onCreate() {
        super.onCreate()
        CONTEXT = applicationContext
        initLogger()
        inItDb()
    }

    init {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
            ClassicsHeader(context)
        }
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, _ ->
              ClassicsFooter(context).setDrawableSize(20f)
        }
    }


    private fun inItDb(){
        LitePal.initialize(this)
    }


    /**
     * 初始化日志框架
     */
    private fun initLogger() {
        val logStrategy = object : LogStrategy {

            private val prefix = arrayOf(". ", " .")
            private var index = 0

            override fun log(priority: Int, tag: String?, message: String) {
                index = index xor 1
                Log.println(priority, prefix[index] + tag!!, message)
            }
        }

        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .logStrategy(logStrategy)
            .showThreadInfo(true)  //（可选）是否显示线程信息。 默认值为true
            .methodCount(0)         // （可选）要显示的方法行数。 默认2
            .methodOffset(7)        // （可选）隐藏内部方法调用到偏移量。 默认5
            .tag("FineVideo") //（可选）每个日志的全局标记。 默认PRETTY_LOGGER
            .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        if (level == ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN) {
            //如果App被置换到后台时，清理所有的内存缓存
            Glide.get(this).clearMemory()
//            GlideBitmapPool.clearMemory()
        }
        //交给Glide处理内存情况
        Glide.get(this).trimMemory(level)
//        GlideBitmapPool.trimMemory(level)
        isLowMemory = level == ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW
    }

    override fun onLowMemory() {
        super.onLowMemory()

        isLowMemory = true
        //内存低的时候，清理Glide的缓存
        Glide.get(this).clearMemory()
    }


}
package com.lai.comicmtc_v2.ui.comm

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity


/**
 *
 * @author  Lai
 *
 * @time 2019/10/13 18:33
 * @describe describe
 *
 */
class ActivityLauncher(activity: AppCompatActivity) {
    private val TAG = "ActivityLauncher"

    private var mContext: Context? = activity
    private var mRouterFragment: RouterFragment? = null

    init {
        mRouterFragment = getRouterFragment(activity)
    }

    companion object{
        fun init(activity: AppCompatActivity): ActivityLauncher {
            return ActivityLauncher(activity)
        }
    }



     fun startActivityForResult(intent: Intent, callback: Callback) {
        mRouterFragment?.startActivityForResult(intent, callback)
    }




    private fun getRouterFragment(activity: AppCompatActivity): RouterFragment? {
        var routerFragment = findRouterFragment(activity)
        if (routerFragment == null) {
            routerFragment = RouterFragment.newInstance()
            val fragmentManager = activity.supportFragmentManager
            fragmentManager
                .beginTransaction()
                .add(routerFragment, TAG)
                .commitAllowingStateLoss()
            fragmentManager.executePendingTransactions()
        }
        return routerFragment
    }

    interface Callback {
        fun onActivityResult(resultCode: Int, data: Intent?)
    }

    private fun findRouterFragment(activity: AppCompatActivity): RouterFragment? {
        return activity.supportFragmentManager.findFragmentByTag(TAG) as RouterFragment?
    }
}
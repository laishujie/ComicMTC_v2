package com.lai.comicmtc_v2.ui.comm

import android.content.Intent
import android.os.Bundle
import android.util.SparseArray
import androidx.fragment.app.Fragment
import java.util.*


/**
 *
 * @author  Lai
 *
 * @time 2019/10/13 18:33
 * @describe describe
 *
 */
class RouterFragment : Fragment() {

    private val mCodeGenerator = Random()
    private val mCallbacks = SparseArray<ActivityLauncher.Callback>()

    companion object{
        fun newInstance(): RouterFragment {
            return RouterFragment()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //当设备旋转时 已保留的fragment不会随着activity一起被销毁；
        retainInstance = true
    }

    fun startActivityForResult(intent: Intent, callback: ActivityLauncher.Callback) {
        val requestCode = makeRequestCode()
        mCallbacks.put(requestCode, callback)
        startActivityForResult(intent, requestCode)
    }


    /**
     * 随机生成唯一的requestCode，最多尝试10次
     *
     * @return
     */
    private fun makeRequestCode(): Int {
        var requestCode: Int
        var tryCount = 0
        do {
            requestCode = mCodeGenerator.nextInt(0x0000FFFF)
            tryCount++
        } while (mCallbacks.indexOfKey(requestCode) >= 0 && tryCount < 10)
        return requestCode
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val callback = mCallbacks.get(requestCode)
        mCallbacks.remove(requestCode)
        callback?.onActivityResult(resultCode, data)
    }

}
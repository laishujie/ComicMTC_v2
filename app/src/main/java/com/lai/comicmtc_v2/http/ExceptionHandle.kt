package com.lai.comicmtc_v2.http

import android.text.TextUtils
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketException
import java.net.UnknownHostException


/**
 * @author Lai
 * @time 2018/10/19 15:09
 * @Description
 */
class ExceptionHandle {
    companion object {
        private val UNAUTHORIZED = 401
        private val FORBIDDEN = 403
        private val NOT_FOUND = 404
        private val REQUEST_TIMEOUT = 408
        private val INTERNAL_SERVER_ERROR = 500
        private val BAD_GATEWAY = 502
        private val SERVICE_UNAVAILABLE = 503
        private val GATEWAY_TIMEOUT = 504

        fun handleException(e: Throwable): Throwable? {
            when (e) {
                is HttpException -> {
                    when (e.code()) {
                        UNAUTHORIZED, FORBIDDEN, NOT_FOUND, REQUEST_TIMEOUT, GATEWAY_TIMEOUT, INTERNAL_SERVER_ERROR, SERVICE_UNAVAILABLE ->
                            return Throwable("网络异常，请检查网络设置")
                        BAD_GATEWAY -> {
                            return Throwable("服务器异常")
                        }
                    }
                }
                is ConnectException -> {
                    return Throwable("网络异常，请检查网络设置")
                }
                is java.net.SocketTimeoutException -> {
                    return Throwable("网络超时，请检查网络设置")
                }
                is UnknownHostException -> {
                    return Throwable("网络异常，请检查网络设置")
                }
                is IOException -> {
                    return Throwable("网络异常，请检查网络设置")
                }
                is SocketException -> {
                    return Throwable("网络异常，请检查网络设置")
                }
            }

            if(!TextUtils.isEmpty(e.message) && e.message!!.contains("Exception")) {
                return Throwable("网络异常，请检查网络设置")
            }

            return if(e.message == null) null else Throwable(e.message)
        }
    }
}
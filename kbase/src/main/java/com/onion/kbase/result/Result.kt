package com.onion.kbase.result

import android.util.MalformedJsonException
import com.google.gson.JsonSyntaxException
import com.onion.kbase.KBase
import com.onion.kbase.logger.Logger
import com.onion.kbase.util.ToastUtil
import io.reactivex.observers.ResourceObserver
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by OnionMac on 2018/4/13.
 */
abstract class Result<T>: ResourceObserver<T>() {

    override fun onNext(t: T) {
        onFinish()
    }

    override fun onError(t: Throwable) {
        onFinish()
        Logger.i(t.toString())
        t.printStackTrace()

        if (t is JsonSyntaxException || t is MalformedJsonException) {
//            ToastUtil.showShort(KBase.app,"服务器数据错误")
            Logger.i("服务器数据错误")
        }

        if (t is HttpException) {
            ToastUtil.showShort(KBase.app,"服务器未响应")
        }

        if (t is SocketTimeoutException) {
            ToastUtil.showShort(KBase.app,"服务器响应超时")
        }

        if (t is ConnectException) {
            ToastUtil.showShort(KBase.app,"服务器连接超时")
        }

        if (t is UnknownHostException) {
            ToastUtil.showShort(KBase.app,"服务器未响应")
        }

    }

    override fun onComplete() {}

    protected open fun onFailed(t: T){}

    protected open fun onFinish() {}

    protected abstract fun onSuccess(t: T)
}
package com.onion.kbase.result

import android.util.MalformedJsonException
import com.google.gson.JsonSyntaxException
import com.onion.kbase.KBase
import com.onion.kbase.exception.ExceptionHelper
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
    }

    override fun onComplete() {}

    //接口失败得时候 不是网络错误
    protected open fun onFailed(t: T){}

    protected open fun onFinish() {}

    protected abstract fun onSuccess(t: T)
}
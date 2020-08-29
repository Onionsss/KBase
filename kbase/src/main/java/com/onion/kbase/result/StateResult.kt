package com.onion.kbase.result

import android.util.MalformedJsonException
import com.google.gson.JsonSyntaxException
import com.onion.kbase.KBase
import com.onion.kbase.bean.HttpWrapper
import com.onion.kbase.exception.ExceptionHelper
import com.onion.kbase.mvp.BaseView
import com.onion.kbase.util.ToastUtil
import com.onion.kbase.view.StateLayout

import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Copyright (C), 2019-2019, 里德软件
 * FileName: DialogResult
 * Author: OnionMac by 张琦
 * Date: 2019/4/24 11:30 AM
 * Description: DialogResult
 */
abstract class StateResult<T,V: BaseView>(var v: V?,var state: StateLayout?): Result<T>() {

    private var loading: Boolean? = true

    init {
        loading = state?.isShowLoding()
    }

    override fun onStart() {
        super.onStart()
        if(loading!!){
            //如果需要loading 则loading
            if(state!!.needLoading){
                state?.showLoading()
            }
        }
    }

    override fun onNext(t: T) {
        super.onNext(t)
        if(t is HttpWrapper<*>){
            if(t.code == 200){
                state?.showContent()
                onSuccess(t)
            }else{
                state?.showError()
                onFailed(t)
            }
        }else{
            state?.showError()
        }
    }

    override fun onFinish() {
        super.onFinish()
    }

    override fun onError(t: Throwable) {
        super.onError(t)

        val errorMsg = ExceptionHelper.helper(t)
        state?.showError()

    }
}
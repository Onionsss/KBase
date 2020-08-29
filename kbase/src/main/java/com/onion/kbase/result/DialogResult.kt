package com.onion.kbase.result

import android.util.Log
import com.onion.kbase.KBase
import com.onion.kbase.bean.HttpWrapper
import com.onion.kbase.exception.ExceptionHelper
import com.onion.kbase.mvp.BaseView
import com.onion.kbase.util.ToastUtil

/**
 * Copyright (C), 2019-2019, 里德软件
 * FileName: DialogResult
 * Author: OnionMac by 张琦
 * Date: 2019/4/24 11:30 AM
 * Description: DialogResult
 */
abstract class DialogResult<T,V: BaseView>(var v: V?,var showMsg: Boolean = true): Result<T>() {

    override fun onStart() {
        super.onStart()
        v?.showDialog()
    }

    override fun onNext(t: T) {
        super.onNext(t)
        if(t is HttpWrapper<*>){
            if(t.code == 200){
                onSuccess(t)
            }else{
                onFailed(t)
                if(showMsg){
                    v?.showMessage(t.msg)
                }
            }
        }else{
            onSuccess(t)
        }
    }

    override fun onFinish() {
        super.onFinish()
        v?.dissDialog()
    }

    override fun onError(t: Throwable) {
        super.onError(t)

        val errorMsg = ExceptionHelper.helper(t)
        if(showMsg){
            ToastUtil.showShort(KBase.app,errorMsg)
        }
    }
}
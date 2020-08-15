package com.onion.kbase.result

import android.util.Log
import com.onion.kbase.bean.HttpWrapper
import com.onion.kbase.mvp.BaseView

/**
 * Copyright (C), 2019-2019, 里德软件
 * FileName: DialogResult
 * Author: OnionMac by 张琦
 * Date: 2019/4/24 11:30 AM
 * Description: DialogResult
 */
abstract class DialogResult<T,V: BaseView>(var v: V?,var msg: String = "加载中..."): Result<T>() {

    override fun onStart() {
        super.onStart()
        v?.showDialog(msg)
    }

    override fun onNext(t: T) {
        super.onNext(t)
        if(t is HttpWrapper<*>){
            if(t.getCode() == 200){
                onSuccess(t)
                //显示成功布局
                //v?.getSuccessView()?.show()
            }else{

                onFailed(t)
                v?.onErrorFailed()
                v?.showMessage(t.getMessage())
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
        Log.d("TAG",t.toString())
        v?.onError(t)
        v?.onErrorFailed()
    }
}
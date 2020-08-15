package com.onion.kbase.result

import com.onion.kbase.bean.HttpWrapper
import com.onion.kbase.mvp.BaseView


/**
 * Copyright (C), 2019-2019, 里德软件
 * FileName: DialogResult
 * Author: OnionMac by 张琦
 * Date: 2019/4/24 11:30 AM
 * Description: DialogResult
 */
abstract class NormalResult<T,V: BaseView>(var v: V?) : Result<T>() {

    override fun onStart() {
        super.onStart()
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
    }

    override fun onError(t: Throwable) {
        super.onError(t)
        v?.onError(t)
        v?.onErrorFailed()
    }
}
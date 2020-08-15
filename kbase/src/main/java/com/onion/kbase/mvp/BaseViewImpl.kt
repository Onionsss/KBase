package com.onion.kbase.mvp


/**
 * Copyright (C), 2019-2019, 里德软件
 * FileName: BaseViewImpl
 * Author: OnionMac by 张琦
 * Date: 2019/5/23 3:02 PM
 * Description:
 */
interface BaseViewImpl: BaseView {

    override fun onError(throwable: Throwable){}

    // 接口错误的时候 和 异常
    override fun onErrorFailed(){}

    //override fun getSuccessView(): View? = null
}
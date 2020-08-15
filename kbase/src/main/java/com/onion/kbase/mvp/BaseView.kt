package com.onion.kbase.mvp

/**
 *  Created by zhangqi on 2019/4/22.
 */
interface BaseView {

    /**
     * 网络进度条
     * @param msg
     */
    fun showDialog(msg: String?)

    /**
     * 结束网络进度条
     */
    fun dissDialog()

    fun showMessage(msg: String?)

    //接口错误
    fun onError(throwable: Throwable)

    // 接口错误的时候 和 异常
    fun onErrorFailed()

    //fun getSuccessView(): View?
}
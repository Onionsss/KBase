package com.onion.kbase.mvp

/**
 *  Created by zhangqi on 2019/4/22.
 */
interface BaseView {

    /**
     * 网络进度条
     * @param msg
     */
    fun showDialog()

    /**
     * 结束网络进度条
     */
    fun dissDialog()

    fun showMessage(msg: String?)

}
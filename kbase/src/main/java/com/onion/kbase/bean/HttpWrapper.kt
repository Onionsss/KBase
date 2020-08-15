package com.onion.kbase.bean

/**
 * Copyright (C), 2019-2020, 里德软件
 * FileName: HttpWrapper
 * Author: Administrator by 张琦
 * Date: 2020/8/15 0015 20:12
 * Description:
 */
class HttpWrapper<T> {

    open fun getCode(): Int {
        return 200
    }

    open fun getMessage(): String {
        return "";
    }
}
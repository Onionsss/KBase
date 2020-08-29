package com.onion.kbase.bean

/**
 *  Created by zhangqi on 2019/4/22.
 */
data class HttpWrapper<T>(val code: Int, val msg: String, val result: T)
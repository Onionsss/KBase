/**
 * Copyright (C), 2019-2019, 里德软件
 * FileName: DialogResult
 * Author: OnionMac by 张琦
 * Date: 2019/4/24 11:30 AM
 */

package com.onion.kbase.result

import com.onion.kbase.mvp.BaseView
import com.onion.kbase.view.StateLayout
import io.reactivex.Observable
import io.reactivex.disposables.Disposable

/**
 * 带dialog得网络请求
 */
fun <T,V: BaseView> Observable<T>.dialog(v: V?, success: (DialogResult<T, V>.(T) -> Unit)? = null,
                                         error: (DialogResult<T, V>.(Throwable) -> Unit)? = null,
                                         finish: (DialogResult<T, V>.() -> Unit)? = null,
                                         failed: (DialogResult<T, V>.(T) -> Unit)? = null,
                                         start: (DialogResult<T, V>.() -> Unit)? = null,
                                         showMsg: Boolean = true,
                                         time: Int = 0):Disposable {
    return this.to(time).subscribeWith(object : DialogResult<T,V>(v,showMsg) {

        override fun onFailed(t: T) {
            super.onFailed(t)
            failed?.let { failed(t) }
        }

        override fun onSuccess(t: T) {
            success?.let { it(t) }
        }

        override fun onStart() {
            super.onStart()
            start?.let {
                start()
            }
        }

        override fun onError(t: Throwable) {
            super.onError(t)
            error?.let { error(t) }
        }

        override fun onFinish() {
            super.onFinish()
            finish?.let {
                finish()
            }
        }
    })
}


fun <T,V: BaseView> Observable<T>.delays(v: V?, success: (DialogResult<T, V>.(T) -> Unit)? = null,
                                         error: (DialogResult<T, V>.(Throwable) -> Unit)? = null,
                                         finish: (DialogResult<T, V>.() -> Unit)? = null,
                                         failed: (DialogResult<T, V>.(T) -> Unit)? = null,
                                         start: (DialogResult<T, V>.() -> Unit)? = null,
                                         showMsg: Boolean = true,
                                         time: Int = 1):Disposable {

    return this.to(time).subscribeWith(object : DialogResult<T,V>(v) {
        override fun onFailed(t: T) {
            super.onFailed(t)
            failed?.let { failed(t) }
        }

        override fun onSuccess(t: T) {
            success?.let { it(t) }
        }

        override fun onStart() {
            super.onStart()
            start?.let {
                start()
            }
        }

        override fun onError(t: Throwable) {
            super.onError(t)

            error?.let { error(t) }
        }

        override fun onFinish() {
            super.onFinish()
            finish?.let {
                finish()
            }
        }
    })
}

fun <T,V: BaseView> Observable<T>.normal(v: V?,
                                         success: (NormalResult<T, V>.(T) -> Unit)? = null,
                                         error: (NormalResult<T, V>.(Throwable) -> Unit)? = null,
                                         failed: (NormalResult<T, V>.(T) -> Unit)? = null,
                                         finish: (NormalResult<T, V>.() -> Unit)? = null,
                                         showMsg: Boolean = true,
                                         time: Int = 0):Disposable {
    
    return this.to(time).subscribeWith(object : NormalResult<T, V>(v,showMsg) {

        override fun onFailed(t: T) {
            super.onFailed(t)
            failed?.let { failed(t) }
        }

        override fun onSuccess(t: T) {
            success?.let { it(t) }
        }

        override fun onError(t: Throwable) {
            super.onError(t)

            error?.let { error(t) }
        }

        override fun onFinish() {
            super.onFinish()
            finish?.let {
                finish()
            }
        }
    })
}

fun <T,V: BaseView> Observable<T>.state(v: V?,
                                         success: (StateResult<T, V>.(T) -> Unit)? = null,
                                         error: (StateResult<T, V>.(Throwable) -> Unit)? = null,
                                         failed: (StateResult<T, V>.(T) -> Unit)? = null,
                                         finish: (StateResult<T, V>.() -> Unit)? = null,
                                         state: StateLayout? = null,
                                         time: Int = 0):Disposable {

    return this.to(time).subscribeWith(object : StateResult<T, V>(v,state) {

        override fun onFailed(t: T) {
            super.onFailed(t)
            failed?.let { failed(t) }
        }

        override fun onSuccess(t: T) {
            success?.let { it(t) }
        }

        override fun onError(t: Throwable) {
            super.onError(t)
            error?.let { error(t) }
        }

        override fun onFinish() {
            super.onFinish()
            finish?.let {
                finish()
            }
        }
    })
}



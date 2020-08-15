package com.onion.kbase.mvp

import io.reactivex.disposables.CompositeDisposable

/**
 *  Created by zhangqi on 2019/4/22.
 */
interface BasePresenter<T: BaseView> {

    fun attachView(view: T)

    fun detachView()

    fun getCompositeDisposable(): CompositeDisposable?
}
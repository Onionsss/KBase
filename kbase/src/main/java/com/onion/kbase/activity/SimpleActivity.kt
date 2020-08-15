package com.onion.kbase.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 *  Created by zhangqi on 2019/4/22.
 */
@SuppressLint("Registered")
abstract class SimpleActivity<D: ViewDataBinding>: MessageActivity() {

    protected lateinit var mContext: Activity

    protected lateinit var mBinding: D



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,getLayoutId())
        mContext = this

        initView()

        initData()

        initListener()
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    override fun onStart() {
        super.onStart()
        initDataOnStart()
    }

    var mCompositeSubscription: CompositeDisposable? = CompositeDisposable()

    fun getCompositeSubscription(): CompositeDisposable? {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = CompositeDisposable()
        }
        return this.mCompositeSubscription
    }

    fun addSubscription(s: Disposable) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = CompositeDisposable()
        }
        this.mCompositeSubscription!!.add(s)
    }

    override fun onDestroy() {
        super.onDestroy()
        mCompositeSubscription?.let {
            it.clear()
            mCompositeSubscription = null
        }
    }


    open fun initDataOnStart(){}

    open fun initView(){
    }

    open fun initData(){}

    open fun initListener(){}


}
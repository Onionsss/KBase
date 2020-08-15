package com.onion.kbase.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/**
 *  Created by zhangqi on 2019/4/23.
 */
abstract class SimpleFragment<D: ViewDataBinding>: MessageFragment() {

    protected lateinit var mBinding: D
    protected var mPageNum = 1
    protected var mPageSize = 10
    //用户可见
    protected var isUserVisible = true
    //初始工作准备好了
    protected var isPrepare = false
    // 第一次加载
    protected var isFirst = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initInject()
        mBinding = DataBindingUtil.inflate(inflater,getLayoutId(),container,false)
        isFirst = true
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        once()
    }

    override fun onSupportVisible() {
        super.onSupportVisible()
        isUserVisible = true
        onShow()
    }

    override fun onSupportInvisible() {
        super.onSupportInvisible()
        isUserVisible = false
        onGone()
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        super.onLazyInitView(savedInstanceState)
        initView(view)
        initData()
        initListener()
        isPrepare = true
    }

    open fun once() {

    }

    override fun onDetach() {
        super.onDetach()
        mCompositeSubscription?.let {
            it.clear()
            mCompositeSubscription = null
        }
    }

    open fun initView(view: View?){
    }

    open fun initData(){}

    open fun initInject(){}

    open fun initListener(){}

    abstract fun getLayoutId(): Int

    open fun onShow(){

    }

    open fun onGone(){

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

}
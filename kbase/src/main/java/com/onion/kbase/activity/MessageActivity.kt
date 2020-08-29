package com.onion.kbase.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.onion.kbase.util.ToastUtil
import com.onion.kbase.view.IOSLoadingDialog

/**
 *  Created by zhangqi on 2019/4/22.
 */
@SuppressLint("Registered")
open class MessageActivity : ConfigActivity() {


    protected lateinit var mProgressDialog: IOSLoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val loadBuilder = IOSLoadingDialog.Builder(this)
            .setMessage("加载中...")
            .setShowMessage(false)
            .setCancelable(true)
            .setCancelOutside(false)
        mProgressDialog = loadBuilder.create()
    }

    fun showMessage(msg: String?){
       ToastUtil.showShort(this,msg)
    }

    fun showMessage(msg: Int){
        showMessage(getString(msg))
    }

    open fun showDialog(){
        // dialog
        try {
            if (isMainThread()) {
//                mProgressDialog.setMessage(msg)
                if (!mProgressDialog.isShowing)
                    mProgressDialog.show()
            } else {
                runOnUiThread {
//                    mProgressDialog.setMessage(msg)
                    if (!mProgressDialog.isShowing)
                        mProgressDialog.show()
                }
            }
        } catch (e: Exception) {

        }

    }

    open fun dissDialog(){
        try {
            if (isMainThread()) {
                if (mProgressDialog.isShowing)
                    mProgressDialog.dismiss()
            } else {
                runOnUiThread {
                    if (mProgressDialog.isShowing)
                        mProgressDialog.dismiss()
                }
            }
        } catch (e: Exception) {

        }

    }



}
package com.onion.kbase.fragment

import android.os.Bundle
import com.onion.kbase.util.ToastUtil
import com.onion.kbase.view.IOSLoadingDialog

/**
 *  Created by zhangqi on 2019/4/23.
 */
abstract class MessageFragment : ConfigFragment() {
    protected lateinit var mProgressDialog: IOSLoadingDialog

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val loadBuilder = IOSLoadingDialog.Builder(mActivity)
            .setMessage("加载中...")
            .setShowMessage(false)
            .setCancelable(true)
            .setCancelOutside(false)
        mProgressDialog = loadBuilder.create()
    }

    fun showMessage(msg: String?) {
        activity.let {
            ToastUtil.showShort(mActivity, msg)
        }
    }

    fun showMessage(msg: Int) {
        showMessage(getString(msg))
    }

    fun showDialog(msg: String? = "") {
        // dialog
        activity.let {
            try {
                mActivity.runOnUiThread {
//                    mProgressDialog.setMessage(msg)
                    if (!mProgressDialog.isShowing)
                        mProgressDialog.show()
                }
            } catch (e: Exception) {

            }
        }
    }

    fun dissDialog() {
        activity.let {
            mProgressDialog.dismiss()
        }
    }
}
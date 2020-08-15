package com.onion.kbase.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Looper
import androidx.annotation.ColorRes
import com.onion.kbase.Manager
import me.yokeyword.fragmentation.SupportActivity



/**
 *  Created by zhangqi on 2019/4/22.
 */
@SuppressLint("Registered")
open class ConfigActivity: SupportActivity() {

    /**
     * 请求页数
     * 请求多少条
     */
    protected var mPageNum = 1
    protected var mPageSize = 10

    protected var mWidth: Int = 0
    protected var mHeight: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Manager.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        Manager.removeThis(this)
    }

    public override fun onResume() {
        super.onResume()
    }

    public override fun onPause() {
        super.onPause()
    }

    fun isMainThread(): Boolean = Looper.getMainLooper() == Looper.myLooper()
}
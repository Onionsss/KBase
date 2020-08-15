package com.onion.kbase.fragment

import android.app.Activity
import me.yokeyword.fragmentation.SupportFragment


/**
 *  Created by zhangqi on 2019/4/23.
 */
abstract class ConfigFragment: SupportFragment() {

    protected lateinit var mActivity: Activity

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        mActivity = activity
    }

}
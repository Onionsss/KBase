package com.onion.kbase

import android.app.Activity
import java.util.*

/**
 * Copyright (C), 2019-2019, 里德软件
 * FileName: Manager
 * Author: OnionMac by 张琦
 * Date: 2019/6/19 11:02 AM
 * Description:
 */
object Manager {

    private var activityList: LinkedList<Activity> = LinkedList()

    fun addActivity(activity: Activity){
        activityList.addLast(activity)
    }

    fun removeLast(){
        activityList.removeLast()
    }

    fun removeThis(activity: Activity){
        activityList.remove(activity)
    }

    //关闭所有activity
    fun closeApp(){
        activityList.forEach {
            it.finish()
        }
    }

    fun removeActivity(activity: Activity){
        activityList.remove(activity)
        activity.finish()
    }

    fun size(): Int{
        return activityList.size
    }

    @JvmStatic
    fun getList(): LinkedList<Activity>{
        return activityList
    }

}
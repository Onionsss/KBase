
package com.onion.kbase
import android.app.Application
import com.onion.kbase.KBase.app


object KBase {

    @JvmStatic
    var app: Application? = null


}

fun getApp(): Application {
    return app!!
}

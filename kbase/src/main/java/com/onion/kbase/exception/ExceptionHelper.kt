package com.onion.kbase.exception

import android.util.MalformedJsonException
import com.google.gson.JsonParseException
import org.apache.http.conn.ConnectTimeoutException
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException
import java.text.ParseException
import javax.net.ssl.SSLException

object ExceptionHelper {

    private const val UNAUTHORIZED = 401
    private const val FORBIDDEN = 403
    private const val NOT_FOUND = 404
    private const val REQUEST_TIMEOUT = 408
    private const val INTERNAL_SERVER_ERROR = 500
    private const val SERVICE_UNAVAILABLE = 503

    fun helper(throwable: Throwable): String{
        var result = "网络错误"
        if(throwable is HttpException){
            when(throwable.code()){
                UNAUTHORIZED -> {
                    //未授权 权限
                    result = "未授权"
                }
                FORBIDDEN -> {
                    result = "请求被拒绝"
                }
                NOT_FOUND -> {
                    result = "请求地址不存在"
                }
                REQUEST_TIMEOUT -> {
                    result = "服务器请求超时"
                }
                INTERNAL_SERVER_ERROR -> {
                    result = "服务器内部错误"
                }
                SERVICE_UNAVAILABLE -> {
                    result = "服务器不可用"
                }

            }
            return result
        }

        if(throwable is JsonParseException || throwable is JSONException || throwable is ParseException || throwable is MalformedJsonException){
            result = "数据解析错误"
            return result
        }

        if(throwable is ConnectException){
            result = "连接错误"
            return result
        }

        if(throwable is SSLException){
            result = "证书验证失败"
            return result
        }

        if(throwable is ConnectTimeoutException){
            result = "连接超时"
            return result
        }

        if(throwable is UnknownHostException){
            result = "未找到主机地址"
            return result
        }

        return result
    }

}
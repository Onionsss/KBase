package com.onion.kbase.banner

import android.content.Context
import android.os.Build
import android.util.AttributeSet

import androidx.appcompat.widget.AppCompatImageView
import com.onion.kbase.banner.provider.ViewStyleSetter


class CornerImageView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : AppCompatImageView(context, attrs, defStyleAttr) {

    fun setRoundCorner(radius: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val viewStyleSetter = ViewStyleSetter(this)
            viewStyleSetter.setRoundCorner(radius.toFloat())
        }
    }
}

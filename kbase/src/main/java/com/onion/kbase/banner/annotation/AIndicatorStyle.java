package com.onion.kbase.banner.annotation;

import androidx.annotation.IntDef;


import com.onion.kbase.banner.constants.IndicatorStyle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * <pre>
 *   Created by zhangpan on 2019-10-18.
 *   Description:
 * </pre>
 */
@IntDef({IndicatorStyle.CIRCLE, IndicatorStyle.DASH})
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PARAMETER)
public @interface AIndicatorStyle {
}

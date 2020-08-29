package com.onion.kbase.banner.annotation;

import androidx.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.onion.kbase.banner.constants.IndicatorGravity.END;
import static com.onion.kbase.banner.constants.IndicatorGravity.START;
import static com.onion.kbase.banner.constants.IndicatorGravity.CENTER;


/**
 * <pre>
 *   Created by zhangpan on 2019-10-18.
 *   Description:指示器显示位置
 * </pre>
 */
@IntDef({CENTER, START, END})
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PARAMETER)
public @interface AIndicatorGravity {

}

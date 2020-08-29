package com.onion.kbase.banner.indicator.drawer;

import android.graphics.Canvas;

/**
 * <pre>
 *   Created by zhpan on 2019/11/23.
 *   Description:
 * </pre>
 */
public interface IDrawer {

    BaseDrawer.MeasureResult onMeasure(int widthMeasureSpec, int heightMeasureSpec);

    void onDraw(Canvas canvas);
}

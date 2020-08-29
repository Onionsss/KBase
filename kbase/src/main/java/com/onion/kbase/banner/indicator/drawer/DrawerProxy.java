package com.onion.kbase.banner.indicator.drawer;

import android.graphics.Canvas;

import com.onion.kbase.banner.manager.IndicatorOptions;


/**
 * <pre>
 *   Created by zhpan on 2019/11/23.
 *   Description: Indicator Drawer Proxy.
 * </pre>
 */
public class DrawerProxy implements IDrawer {

    private IDrawer mIDrawer;

    public DrawerProxy(IndicatorOptions indicatorOptions) {
        init(indicatorOptions);
    }

    private void init(IndicatorOptions indicatorOptions) {
        mIDrawer = DrawerFactory.createDrawer(indicatorOptions);
    }

    public void setIndicatorOptions(IndicatorOptions indicatorOptions) {
        init(indicatorOptions);
    }

    @Override
    public BaseDrawer.MeasureResult onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        return mIDrawer.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void onDraw(Canvas canvas) {
        mIDrawer.onDraw(canvas);
    }
}

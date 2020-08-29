package com.onion.kbase.banner.indicator.drawer;

import android.graphics.Canvas;

import com.onion.kbase.banner.manager.IndicatorOptions;


/**
 * <pre>
 *   Created by zhpan on 2019/11/23.
 *   Description: Circle Indicator drawer.
 * </pre>
 */
public class CircleDrawer extends BaseDrawer {

    private float maxWidth;

    private float minWidth;

    CircleDrawer(IndicatorOptions indicatorOptions) {
        super(indicatorOptions);
    }

    @Override
    public MeasureResult onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        maxWidth = Math.max(mIndicatorOptions.getNormalIndicatorWidth(), mIndicatorOptions.getCheckedIndicatorWidth());
        minWidth = Math.min(mIndicatorOptions.getNormalIndicatorWidth(), mIndicatorOptions.getCheckedIndicatorWidth());
        mMeasureResult.setMeasureResult(getMeasureWidth(), (int)maxWidth);
        return mMeasureResult;
    }

    private int getMeasureWidth() {
        int pageSize = mIndicatorOptions.getPageSize();
        float indicatorGap = mIndicatorOptions.getIndicatorGap();
        return (int) ((pageSize - 1) * indicatorGap + maxWidth + (pageSize - 1) * minWidth);
    }

    @Override
    public void onDraw(Canvas canvas) {
        drawIndicator(canvas);
    }

    private void drawIndicator(Canvas canvas) {
        if (mIndicatorOptions.getPageSize() > 1) {
            float normalIndicatorWidth = mIndicatorOptions.getNormalIndicatorWidth();
            for (int i = 0; i < mIndicatorOptions.getPageSize(); i++) {
                mPaint.setColor(mIndicatorOptions.getNormalColor());
                canvas.drawCircle(maxWidth / 2 + (normalIndicatorWidth + mIndicatorOptions.getIndicatorGap()) * i,
                        maxWidth / 2f, normalIndicatorWidth / 2, mPaint);
            }
            drawSliderStyle(canvas);
        }
    }

    private void drawSliderStyle(Canvas canvas) {
        mPaint.setColor(mIndicatorOptions.getCheckedColor());
        float normalIndicatorWidth = mIndicatorOptions.getNormalIndicatorWidth();
        float indicatorGap = mIndicatorOptions.getIndicatorGap();
        canvas.drawCircle(maxWidth / 2 + (normalIndicatorWidth + indicatorGap) * mIndicatorOptions.getCurrentPosition() + (normalIndicatorWidth + indicatorGap) * mIndicatorOptions.getSlideProgress(),
                maxWidth / 2f, mIndicatorOptions.getCheckedIndicatorWidth() / 2, mPaint);
    }
}

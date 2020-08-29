package com.onion.kbase.banner.indicator.drawer;

import com.onion.kbase.banner.constants.IndicatorStyle;
import com.onion.kbase.banner.manager.IndicatorOptions;

/**
 * <pre>
 *   Created by zhpan on 2019/11/24.
 *   Description: Indicator Drawer Factory.
 * </pre>
 */
class DrawerFactory {
    static IDrawer createDrawer(IndicatorOptions indicatorOptions) {
        IDrawer drawer;
        if (indicatorOptions.getIndicatorStyle() == IndicatorStyle.DASH) {
            drawer = new DashDrawer(indicatorOptions);
        } else {
            drawer = new CircleDrawer(indicatorOptions);
        }
        return drawer;
    }
}

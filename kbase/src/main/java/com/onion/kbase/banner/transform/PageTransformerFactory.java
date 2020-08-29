package com.onion.kbase.banner.transform;

import androidx.viewpager.widget.ViewPager;

import static com.onion.kbase.banner.constants.TransformerStyle.DEPTH;
import static com.onion.kbase.banner.constants.TransformerStyle.ACCORDION;
import static com.onion.kbase.banner.constants.TransformerStyle.ROTATE;
import static com.onion.kbase.banner.constants.TransformerStyle.STACK;



public class PageTransformerFactory {

    public ViewPager.PageTransformer createPageTransformer(int transformerStyle) {
        ViewPager.PageTransformer transformer = null;
        switch (transformerStyle) {
            case DEPTH:
                transformer = new DepthPageTransformer();
                break;
            case ROTATE:
                transformer=new RotateUpTransformer();
                break;
            case STACK:
                transformer = new StackTransformer();
                break;
            case ACCORDION:
                transformer = new AccordionTransformer();
                break;
        }
        return transformer;
    }
}

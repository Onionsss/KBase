package com.onion.kbase.banner.holder;

/**
 * Created by zhpan on 2017/10/30.
 * Description:
 */

public interface HolderCreator<VH extends ViewHolder> {
    /**
     * 创建ViewHolder
     */
    VH createViewHolder();
}

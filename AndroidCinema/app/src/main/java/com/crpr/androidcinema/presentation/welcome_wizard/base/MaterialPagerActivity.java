package com.crpr.androidcinema.presentation.welcome_wizard.base;

import com.crpr.androidcinema.R;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public abstract class MaterialPagerActivity extends PagerActivity {

    @Override
    protected MODE getNavButtonMode() {
        return MODE.MATERIAL;
    }

    @Override
    protected int getResLayout() {
        return R.layout.activity_material_pager;
    }
}

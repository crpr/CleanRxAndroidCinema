package com.crpr.androidcinema.presentation.welcome_wizard.controllers;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.ShapeDrawable;
import android.widget.ImageView;

import com.crpr.androidcinema.R;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class MaterialNavButtonController implements NavButtonController {

    ImageView _button;
    Context _context;
    int _contentColor;

    public MaterialNavButtonController(Context context, ImageView button){
        _button = button;
        _context = context;
    }

    @Override
    public void config() {
        //setNextContent();
        //setContentColor(android.R.color.white);
        setBackgroundColor(R.color.default_selected_indicator);
    }

    @Override
    public void setButtonStateLabels(String nextLabel, String doneLabel) {
        //not used
    }

    @Override
    public void setContentColor(int color) {
        _contentColor = color;
        _button.getDrawable().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
    }

    @Override
    public void setBackgroundColor(int color) {
        ShapeDrawable drawable = new ShapeDrawable();
        drawable.setBounds(0, 0, 35, 35);
        drawable.getPaint().setColor(color);
        _button.setBackground(drawable);
    }

    @Override
    public void setNextContent() {
        /*Drawable drawable = ContextCompat.getDrawable(_context, R.drawable.ic_chevron_right_white_24dp);
        drawable.setColorFilter(_contentColor, PorterDuff.Mode.MULTIPLY);
        _button.setImageDrawable(drawable);*/
    }

    @Override
    public void setDoneContent() {
        /*Drawable drawable = ContextCompat.getDrawable(_context, R.drawable.ic_check_white_24dp);
        drawable.setColorFilter(_contentColor, PorterDuff.Mode.MULTIPLY);
        _button.setImageDrawable(drawable);*/
    }
}

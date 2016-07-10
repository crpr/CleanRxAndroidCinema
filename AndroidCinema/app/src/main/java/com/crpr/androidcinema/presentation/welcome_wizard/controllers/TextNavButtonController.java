package com.crpr.androidcinema.presentation.welcome_wizard.controllers;

import android.content.Context;
import android.widget.Button;

import com.crpr.androidcinema.R;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class TextNavButtonController implements NavButtonController {

    Button _button;
    String _nextLabel;
    String _doneLabel;
    Context _context;

    public TextNavButtonController(Context context, Button button){
        _button = button;
        _context = context;
    }

    @Override
    public void config() {
        setButtonStateLabels(_context.getString(R.string.ww_next_btn_label),
                _context.getString(R.string.ww_done_btn_label));
    }

    @Override
    public void setButtonStateLabels(String nextLabel, String doneLabel) {
        _nextLabel = nextLabel;
        _doneLabel = doneLabel;
        setNextContent();
    }

    @Override
    public void setContentColor(int color) {
        _button.setTextColor(color);
    }

    @Override
    public void setBackgroundColor(int color) {
        _button.setBackgroundColor(color);
    }

    @Override
    public void setNextContent() {
        _button.setText(_nextLabel);
    }

    @Override
    public void setDoneContent() {
        _button.setText(_doneLabel);
    }
}

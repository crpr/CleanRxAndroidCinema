package com.crpr.androidcinema.presentation.welcome_wizard.controllers;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public interface NavButtonController {
    void config();
    void setButtonStateLabels(String nextLabel, String doneLabel);
    void setContentColor(int color);
    void setBackgroundColor(int color);
    void setNextContent();
    void setDoneContent();
}

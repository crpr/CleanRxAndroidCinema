package com.crpr.androidcinema.presentation.welcome_wizard.controllers;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public interface IndicatorController {
    boolean canGoForward();
    void goToNextSlide();
    int getCurrentPosition();
    void setSelectedIndicatorColor(int color, boolean update);
    void setUnselectedIndicatorColor(int color, boolean update);
    void updateSlidesCount(int slidesCount);
    void setIndicatorsVisibility(boolean show);
    void selectPosition(int position);
    boolean navigateToLastSlide(int position);
}

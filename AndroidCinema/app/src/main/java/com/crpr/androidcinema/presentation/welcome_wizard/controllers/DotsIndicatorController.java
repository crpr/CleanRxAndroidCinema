package com.crpr.androidcinema.presentation.welcome_wizard.controllers;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class DotsIndicatorController implements IndicatorController{

    public final static int DEFAULT_COLOR = 1;

    private Context _context;
    private LinearLayout _indicatorsLayout;
    private int _slidesCount;
    int _selectedIndicatorColor = DEFAULT_COLOR;
    int _unselectedIndicatorColor = DEFAULT_COLOR;
    int _currentPosition;

    private static final int FIRST_PAGE_NUM = 0;

    public DotsIndicatorController(Context context, LinearLayout layout, int slideCount) {
        this(context, layout, slideCount, FIRST_PAGE_NUM);
    }

    public DotsIndicatorController(Context context, LinearLayout layout, int slideCount, int startIndex) {
        _context = context;
        _indicatorsLayout = layout;
        _slidesCount = slideCount;
        _selectedIndicatorColor = -1;
        _unselectedIndicatorColor = -1;
    }

    public void updateSlidesCount(int count){
        _slidesCount = count;
        selectPosition(0);
    }

    private void buildIndicators(int currentSlide){
        _indicatorsLayout.removeAllViews();

        for (int i = 0; i < _slidesCount; i++) {
            TextView textView = new TextView(_context);
            textView.setText(Html.fromHtml("&#8226;"));
            textView.setTextSize(35);
            textView.setTextColor(_unselectedIndicatorColor);
            textView.setAlpha(0.4f);
            _indicatorsLayout.addView(textView);
        }

        if (_slidesCount > 0 && _indicatorsLayout.getChildAt(currentSlide) != null) {
            ((TextView)_indicatorsLayout.getChildAt(currentSlide))
                    .setTextColor(_selectedIndicatorColor);
            _indicatorsLayout.getChildAt(currentSlide).setAlpha(1f);
        }
    }

    public void selectPosition(int index) {
        _currentPosition = index;
        buildIndicators(index);
    }

    public void setSelectedIndicatorColor(int color, boolean update) {
        _selectedIndicatorColor = color;

        if(update) {
            selectPosition(_currentPosition);
        }
    }

    public void setUnselectedIndicatorColor(int color, boolean update) {
        _unselectedIndicatorColor = color;
        if(update) {
            selectPosition(_currentPosition);
        }
    }

    public void setIndicatorsVisibility(boolean show){
        _indicatorsLayout.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }

    public boolean canGoForward(){
        return _currentPosition < _slidesCount-1;
    }

    public void goToNextSlide() {
        selectPosition(_currentPosition+1);
    }

    public int getCurrentPosition(){
        return _currentPosition;
    }

    public boolean navigateToLastSlide(int position) {
        return position == _slidesCount-1;
    }

}

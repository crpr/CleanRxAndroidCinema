package com.crpr.androidcinema.presentation.welcome_wizard.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.crpr.androidcinema.R;
import com.crpr.androidcinema.presentation.welcome_wizard.controllers.DotsIndicatorController;
import com.crpr.androidcinema.presentation.welcome_wizard.controllers.IndicatorController;
import com.crpr.androidcinema.presentation.welcome_wizard.controllers.MaterialNavButtonController;
import com.crpr.androidcinema.presentation.welcome_wizard.controllers.NavButtonController;
import com.crpr.androidcinema.presentation.welcome_wizard.controllers.TextNavButtonController;

import java.util.List;
import java.util.Vector;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public abstract class PagerActivity extends AppCompatActivity {

    public enum MODE {
        TEXT,
        MATERIAL
    }

    private ViewPager _pager;
    private CustomPagerAdapter _pagerAdapter;
    private List<Fragment> _slides = new Vector<>();
    private IndicatorController _controller;
    private Button _skipButton;
    private View _nextDoneTextButton;
    private NavButtonController _navController;
    private RelativeLayout _navBarWrapper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getResLayout());

        _pager = (ViewPager) findViewById(R.id.welcome_wizard_view_pager);
        _pagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(), _slides);
        _skipButton = (Button) findViewById(R.id.welcome_wizard_btn_skip);
        _nextDoneTextButton = findViewById(R.id.welcome_wizard_next_done);
        _navBarWrapper = (RelativeLayout) findViewById(R.id.welcome_wizard_nav_wrapper);
        _pager.setAdapter(_pagerAdapter);

        setNavButtonController(getNavButtonMode());
        initIndicatorsController();

        setListeners();
        setDefaults();

        _pager.setCurrentItem(0);
    }

    protected abstract void onSkipPressed();
    protected abstract void onDonePressed();
    protected abstract void onNextPressed();

    protected int getResLayout(){
        return R.layout.activity_pager;
    }

    protected MODE getNavButtonMode(){
        return MODE.TEXT;
    }

    private void setListeners() {
        _skipButton.setOnClickListener(v -> onSkipPressed());

        _nextDoneTextButton.setOnClickListener(v -> checkNextOrDoneSlide());

        _pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                _controller.selectPosition(position);

                if(!_controller.navigateToLastSlide(position)){
                    if(_controller.canGoForward()){
                        _navController.setNextContent();
                        return;
                    }
                }

                _navController.setDoneContent();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setDefaults() {
        _navController.setNextContent();
        _skipButton.setText(getString(R.string.ww_skip_btn_label));
    }

    private void checkNextOrDoneSlide() {
        if(_controller.canGoForward()){
            _controller.goToNextSlide();
            _pager.setCurrentItem(_controller.getCurrentPosition());
            onNextPressed();

            if(_controller.canGoForward()){
                _navController.setNextContent();
                return;
            }

            _navController.setDoneContent();
            return;
        }

        _navController.setDoneContent();
        onDonePressed();
    }

    private int getSlidesCount(){
        return _pagerAdapter.getFragments().size();
    }

    private void initIndicatorsController(){
        if (_controller == null)
            _controller = new DotsIndicatorController(this,
                    (LinearLayout) findViewById(R.id.welcome_wizard_indicators_layout), getSlidesCount());

        _controller.setSelectedIndicatorColor(ContextCompat.getColor(this, R.color.default_selected_indicator), false);
        _controller.setUnselectedIndicatorColor(ContextCompat.getColor(this, R.color.default_unselected_indicator), false);
    }

    private void setNavButtonController(MODE mode) {
        if(mode == null || mode == MODE.TEXT){
            _navController = new TextNavButtonController(getApplicationContext(), (Button)_nextDoneTextButton);
        } else {
            _navController = new MaterialNavButtonController(getApplicationContext(), (ImageView) _nextDoneTextButton);
        }

        _navController.config();
    }

    public void addSlide(Fragment fragment){
        _slides.add(fragment);
        _pagerAdapter.notifyDataSetChanged();
        _controller.updateSlidesCount(getSlidesCount());
    }

    public void enableSkipButton(boolean enable){
        _skipButton.setVisibility(enable ? View.VISIBLE : View.INVISIBLE);
    }

    public void setSkipTextColor(int color){
        _skipButton.setTextColor(color);
    }

    public void setSkipText(String text){
        _skipButton.setText(text);
    }

    public void setIndicatorSelectedColor(int color){
        _controller.setSelectedIndicatorColor(color, true);
    }

    public void setIndicatorUnselectedColor(int color){
        _controller.setUnselectedIndicatorColor(color, true);
    }

    public void setNextDoneText(String nextLabel, String doneLabel){
        _navController.setButtonStateLabels(nextLabel, doneLabel);
    }

    public void setNavBarBackgroundColor(int color){
        _navBarWrapper.setBackgroundColor(color);
    }

    public void setNextDoneContentColor(int color){
        _navController.setContentColor(color);
    }

    public void setNextDoneBackgroundColor(int color){
        _navController.setBackgroundColor(color);
    }

    public void showIndicators(boolean show){
        _controller.setIndicatorsVisibility(show);
    }

}

package com.crpr.androidcinema.presentation.welcome_wizard;

import android.content.Context;

import com.crpr.androidcinema.R;
import com.crpr.androidcinema.presentation.welcome_wizard.fragments.DefaultSlideFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by claudioribeiro on 09/07/16.
 */
public class WelcomeWizardStepsGenerator {

    private final Context _context;

    public WelcomeWizardStepsGenerator(Context context){
        _context = context;
    }

    public List<DefaultSlideFragment> getSlides(){

        List<DefaultSlideFragment> slides = new ArrayList<>(3);

        slides.add(DefaultSlideFragment.newInstance(_context.getString(R.string.welcome_wizard_slide_1_title),
                _context.getString(R.string.welcome_wizard_slide_1_description),
                R.mipmap.ic_launcher));

        slides.add(DefaultSlideFragment.newInstance(_context.getString(R.string.welcome_wizard_slide_2_title),
                _context.getString(R.string.welcome_wizard_slide_2_description),
                R.mipmap.ic_launcher));

        slides.add(DefaultSlideFragment.newInstance(_context.getString(R.string.welcome_wizard_slide_3_title),
                _context.getString(R.string.welcome_wizard_slide_3_description),
                R.mipmap.ic_launcher));

        return slides;
    }

}

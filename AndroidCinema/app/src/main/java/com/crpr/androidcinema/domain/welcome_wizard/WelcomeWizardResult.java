package com.crpr.androidcinema.domain.welcome_wizard;

import com.crpr.androidcinema.domain.common.Result;

/**
 * Created by claudioribeiro on 14/07/16.
 */
public class WelcomeWizardResult extends Result {

    private boolean isWelcomeWizardDone;

    public WelcomeWizardResult(int statusCode, boolean isWelcomeWizardDone) {
        super(statusCode);
        this.isWelcomeWizardDone = isWelcomeWizardDone;
    }

    public boolean isWelcomeWizardDone(){
        return this.isWelcomeWizardDone;
    }
}

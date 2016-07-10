package com.crpr.androidcinema.data.preferences;

import android.content.SharedPreferences;

/**
 * Created by claudioribeiro on 10/07/16.
 */
public interface PreferencesService {
    SharedPreferences getPreferences();
    void setWelcomeWizardDone(boolean isDone);
    boolean isWelcomeWizardDone();
}

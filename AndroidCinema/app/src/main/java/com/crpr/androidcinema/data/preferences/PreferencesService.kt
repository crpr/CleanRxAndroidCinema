package com.crpr.androidcinema.data.preferences

import android.content.SharedPreferences

/**
 * Created by claudioribeiro on 10/07/16.
 */
interface PreferencesService {
    val preferences: SharedPreferences
    var isWelcomeWizardDone: Boolean
}

package com.crpr.androidcinema.domain.welcome_wizard

import com.crpr.androidcinema.domain.common.Result

/**
 * Created by claudioribeiro on 14/07/16.
 */
class WelcomeWizardResult : Result {

    var isWelcomeWizardDone: Boolean = false

    constructor(statusCode: Int, isWelcomeWizardDone: Boolean) : super(statusCode) {
        this.isWelcomeWizardDone = isWelcomeWizardDone
    }

    constructor(statusCode: Int, errorMessage: String) : super(statusCode, errorMessage) {}
}

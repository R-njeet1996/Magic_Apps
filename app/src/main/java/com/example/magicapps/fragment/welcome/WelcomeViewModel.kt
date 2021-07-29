package com.example.magicapps.fragment.welcome

import com.app.base.BaseViewModel

class WelcomeViewModel : BaseViewModel<WelcomeNavigator, WelcomeRepo>() {

    fun launchMyTask()
    {
        getNavigator()?.launchMyTask()
    }
}
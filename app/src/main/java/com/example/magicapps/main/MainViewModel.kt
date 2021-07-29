package com.example.magicapps.main

import android.text.TextUtils
import com.app.base.BaseViewModel

class MainViewModel: BaseViewModel<MainNavigator, MainRepo>() {

    fun loginMethod(email:String, password:String) {

        if (isValidate(email, password)) {

           getNavigator()?.launchWelcome(email, password)

        }
    }

    private fun isValidate(email:String, password:String): Boolean {
        if (TextUtils.isEmpty(email.trim())) {
            getNavigator()?.showError("Please enter user name")
            return false
        }
        else  if (TextUtils.isEmpty(password.trim())) {
            getNavigator()?.showError("Please enter password")
            return false
        }
        else
        {
            return true
        }
    }


}
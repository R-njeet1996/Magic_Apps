package com.example.magicapps.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

object PrefKeeper {

    private var prefs: SharedPreferences? = null

    var isLoggedIn: Boolean
        get() = prefs!!.getBoolean(AppConstant.IntentExtra.LOGGED_IN, false)
        set(isLoggedIn) = prefs!!.edit().putBoolean(AppConstant.IntentExtra.LOGGED_IN, isLoggedIn).apply()

    var userName: String
        get() = prefs!!.getString(AppConstant.IntentExtra.USER_NAME, "").toString()
        set(isLoggedIn) = prefs!!.edit().putString(AppConstant.IntentExtra.USER_NAME, isLoggedIn).apply()

    var password: String
        get() = prefs!!.getString(AppConstant.IntentExtra.PASSWORD, "").toString()
        set(isLoggedIn) = prefs!!.edit().putString(AppConstant.IntentExtra.PASSWORD, isLoggedIn).apply()

    fun clear() = prefs?.edit()?.clear()?.apply()
    fun init(context: Context) {
        if (prefs == null)
            prefs = PreferenceManager.getDefaultSharedPreferences(context)
    }
}
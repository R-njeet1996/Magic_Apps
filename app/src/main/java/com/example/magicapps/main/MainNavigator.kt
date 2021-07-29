package com.example.magicapps.main

interface MainNavigator {

    fun showError(error:String)

    fun launchWelcome(email:String, password:String)
}
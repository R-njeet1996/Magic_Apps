package com.app.base


import androidx.lifecycle.ViewModel
import java.lang.ref.WeakReference
import androidx.databinding.ObservableBoolean


open class BaseViewModel<N, R> : ViewModel() {

    private var mRepo : R? = null
    private var mNavigator : WeakReference<N>? = null
   private val mIsLoading = ObservableBoolean()

    fun getRepo(): R? {
        return mRepo
    }

    fun setRepo(repo : R) {
        this.mRepo = repo
    }

    fun getNavigator(): N? {
        return mNavigator?.get()
    }

    fun setNavigator(navigator: N) {
        this.mNavigator = WeakReference(navigator)
    }

    fun getIsLoading(): ObservableBoolean {
        return mIsLoading
    }

    fun setIsLoading(isLoading: Boolean) {
        mIsLoading.set(isLoading)
    }
}

package com.app.base
import android.app.Application
import com.example.magicapps.utils.PrefKeeper


class MagicApplication: Application() {


    override fun onCreate() {
        super.onCreate()

        PrefKeeper.init(this)
    }




}



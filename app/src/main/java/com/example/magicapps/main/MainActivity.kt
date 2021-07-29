package com.example.magicapps.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.app.base.BaseActivity
import com.example.magicapps.R
import com.example.magicapps.databinding.ActivityMainBinding
import com.example.magicapps.home.HomeActivity
import com.example.magicapps.utils.OnClick
import com.example.magicapps.utils.PrefKeeper

class MainActivity : BaseActivity() ,MainNavigator{
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.lifecycleOwner = this

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mBinding.viewModel = viewModel
        viewModel.setNavigator(this)
        val repo = MainRepo()
        viewModel.setRepo(repo)

        if(PrefKeeper.isLoggedIn)
        {
            launchActivity(HomeActivity::class.java)
             finish()
        }
    }

    override fun showError(error:String) {
        showMsgToast(error)
    }

    override fun launchWelcome(email: String, password: String) {
        PrefKeeper.userName=email
        PrefKeeper.password = password
        PrefKeeper.isLoggedIn = true
        launchActivity(HomeActivity::class.java)
        finish()
    }


}
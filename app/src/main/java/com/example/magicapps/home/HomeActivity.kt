package com.example.magicapps.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import com.app.base.BaseActivity
import com.example.magicapps.R
import com.example.magicapps.databinding.ActivityHomeBinding
import com.example.magicapps.fragment.task.TaskFragment
import com.example.magicapps.fragment.welcome.WelcomeFragment
import com.example.magicapps.utils.OnClick


class HomeActivity : BaseActivity(),HomeNavigator, OnClick {
    private lateinit var mBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        mBinding.lifecycleOwner = this

        val viewModel = ViewModelProviders.of(this).get(HomeViewModle::class.java)
        mBinding.viewModel = viewModel
        viewModel.setNavigator(this)
        val repo = HomeRepo()
        viewModel.setRepo(repo)

        setFragment(1)
    }

    private fun setFragment(type: Int) {

        if(type==1) {
            var fragment = WelcomeFragment(this)
            val fragmentManager: FragmentManager =
                (this as FragmentActivity).supportFragmentManager
            fragmentManager.beginTransaction()
                .replace(R.id.frame, fragment)
                .commit()

        }

        else
        {
            var fragment = TaskFragment()
            val fragmentManager: FragmentManager =
                (this as FragmentActivity).supportFragmentManager
            fragmentManager.beginTransaction()
                .replace(R.id.frame, fragment)
                .commit()
        }



    }

    override fun onClick(type: Int) {
        setFragment(type)
    }
}
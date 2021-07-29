package com.example.magicapps.fragment.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.magicapps.R
import com.example.magicapps.databinding.FragmentWelcomeBinding
import com.example.magicapps.utils.OnClick
import com.example.magicapps.utils.PrefKeeper


class WelcomeFragment(var onClick: OnClick) : Fragment(),WelcomeNavigator {


    private lateinit var mBinding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_welcome, container, false)
        val view: View = mBinding.getRoot()
        mBinding.lifecycleOwner = this
        val viewModel = ViewModelProviders.of(this).get(WelcomeViewModel::class.java)
        mBinding.viewModel = viewModel
        viewModel.setNavigator(this)
        val repo = WelcomeRepo()
        viewModel.setRepo(repo)

        mBinding.tvName.setText(""+resources.getString(R.string.welcome)+" "+PrefKeeper.userName)

        return  view
    }

    override fun launchMyTask() {
       onClick.onClick(2)
    }


}
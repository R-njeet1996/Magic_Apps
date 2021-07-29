package com.example.magicapps.fragment.task

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.magicapps.R
import com.example.magicapps.adapter.PhotoAdapter
import com.example.magicapps.databinding.FragmentTaskBinding
import com.example.magicapps.databinding.FragmentWelcomeBinding
import com.example.magicapps.fragment.welcome.WelcomeRepo
import com.example.magicapps.fragment.welcome.WelcomeViewModel
import com.example.magicapps.utils.ItemClickListener


class TaskFragment : Fragment() ,TaskNavigator,ItemClickListener{
    private lateinit var mBinding: FragmentTaskBinding
    private var task :ArrayList<String> = ArrayList()
    private var image :ArrayList<String> = ArrayList()
    private  var photoAdapter: PhotoAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_task, container, false)
        val view: View = mBinding.getRoot()
        mBinding.lifecycleOwner = this
        val viewModel = ViewModelProviders.of(this).get(TaskViewModel::class.java)
        mBinding.viewModel = viewModel
        viewModel.setNavigator(this)
        val repo = TaskRepo()
        viewModel.setRepo(repo)

         setAdapter()
        return  view
    }

    private fun setAdapter() {
        task.clear()
        task.addAll(resources.getStringArray(R.array.task))
        image.clear()
        image.addAll(resources.getStringArray(R.array.image))
        mBinding.rvTask.setLayoutManager(GridLayoutManager(getActivity(),2))
        photoAdapter = PhotoAdapter(requireActivity(),task,image,this)
        mBinding.rvTask.adapter = photoAdapter
    }

    override fun onItemCLickListener(view: View?, pos: Int) {

        showAlertDialog(requireActivity(),task.get(pos))

    }

    fun showAlertDialog(context: Activity, msg: String?) {
        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.inflater_dialog)
        if (!dialog.isShowing && !context.isFinishing()) dialog.show()

        val tvMsg: AppCompatTextView = dialog.findViewById(R.id.tv_name)
        val tvOk: AppCompatTextView = dialog.findViewById(R.id.tv_ok)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

          tvMsg.setText(msg)


        tvOk.setOnClickListener {

            dialog.dismiss()
        }
    }
}
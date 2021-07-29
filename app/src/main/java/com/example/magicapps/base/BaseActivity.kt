package com.app.base

import android.app.Activity
import android.app.Dialog
import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.example.magicapps.R


open class BaseActivity : AppCompatActivity() {

    protected var baseActivity: BaseActivity? = null
    private var mProgressDialog: ProgressDialog? = null
    private var alertDialog: Dialog? = null
    private var mToast: Toast? = null
    private var fragmentTag: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

    }





    fun launchActivity(activityClass: Class<out BaseActivity>) {
        startActivity(Intent(this, activityClass))
    }

    fun hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }



    fun showMsgToast(@StringRes resId: Int) {
        if (mToast != null) {
            mToast?.cancel()
            mToast = null
        }
        mToast = Toast.makeText(this, resId, Toast.LENGTH_SHORT)
        mToast?.show()
    }

    fun showMsgToast(msg: String) {
        if (mToast != null) {
            mToast?.cancel()
            mToast = null
        }
        mToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT)
        mToast?.show()
    }

    fun showProgressBar() {
        if (mProgressDialog == null) {
            mProgressDialog = ProgressDialog(this)
        }
        if (!(mProgressDialog!!.isShowing)) {
            try {
                mProgressDialog?.show()
            } catch (e: WindowManager.BadTokenException) {
                e.printStackTrace()
            }
        }
        mProgressDialog?.setCancelable(false)
        mProgressDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        mProgressDialog?.setContentView(R.layout.progress_dialog)
    }

    fun hideProgressBar() {
        mProgressDialog?.dismiss()
        mProgressDialog = null
    }



}

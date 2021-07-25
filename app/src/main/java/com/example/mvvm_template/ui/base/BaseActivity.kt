package com.example.mvvm_template.ui.base


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

import com.example.mvvm_template.R
import com.example.mvvm_template.utils.showLoadingDialog


abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    private lateinit var mViewDataBinding: T
    private var mProgressDialog: LoadingDialog? = null
    var baseViewModel: BaseViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dm = resources.displayMetrics
        val conf = resources.configuration
//        val lang = "ar"
//        conf.setLocale(Locale(lang.toLowerCase())) // API 17+ only.
//       resources.updateConfiguration(conf, dm)
        performDataBinding()
        //added
        val window: Window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        observeViewModel()
        initLoaderObservable()
        initMessageObservable()
        initHideKeyboardObservable()
    }



    open fun setUpViewModel(baseViewModel: BaseViewModel) {
        this.baseViewModel = baseViewModel
    }

    open fun showLoading() {
        hideLoading()
        mProgressDialog = showLoadingDialog(this)
        mProgressDialog?.showDialog()
    }

    open fun isLoading(): Boolean? {
        return mProgressDialog?.isShowing
    }

    open fun hideLoading() {
        mProgressDialog?.dism()
    }


    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int
    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mViewDataBinding.executePendingBindings()

    }


    fun initLoaderObservable() {
        baseViewModel?.loaderLiveDat?.observe(this) {
            if (it) {
                showLoading()
            } else {
                hideLoading()
            }
        }
    }

    private  fun initHideKeyboardObservable() {
        baseViewModel?.hideKeyboardLiveDat?.observe(this) { v ->  }
    }

    open fun onError(message: String?) {
        if (message != null && !message.isEmpty()) {
            this.showSnackBar(message)
        } else {
            this.showSnackBar(getString(R.string.some_error))
        }
    }
    open fun showMessage(@StringRes resId: Int) {
        showMessage(getString(resId))
    }

    open fun onError(@StringRes resId: Int) {
        onError(getString(resId))
    }

    fun initMessageObservable() {
        baseViewModel?.messageLiveDat?.observe(this) { message ->
            if (message.type == MessageType.INFO_MSG) {
                if (message.messageResourceId == -1) {
                    showMessage(message.messageText)
                } else {
                    showMessage(message.messageResourceId)
                }
            } else if (message.type == MessageType.ERROR_MSG) {
                if (message.messageResourceId == -1) {
                    onError(message.messageText)
                } else {
                    onError(message.messageResourceId)
                }
            }
        }
    }


    open fun showMessage(message: String?) {
        if (message != null && message.isNotEmpty()) {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, getString(R.string.some_error), Toast.LENGTH_LONG).show()
        }
    }
    abstract fun observeViewModel()


    fun getViewDataBinding(): T {
        return mViewDataBinding
    }

    override fun onDestroy() {
        super.onDestroy()
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}
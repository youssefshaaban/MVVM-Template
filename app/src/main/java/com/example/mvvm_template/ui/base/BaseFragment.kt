package com.example.mvvm_template.ui.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.mvvm_template.R


abstract class BaseFragment<T : ViewDataBinding> : DialogFragment() {

    private var mActivity: BaseActivity<*>? = null
  //  private lateinit var mRootView: View
    private lateinit var mViewDataBinding: T
    var baseViewModel: BaseViewModel?=null
    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun observeViewModel()
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*>) {
            this.mActivity = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return mViewDataBinding.root
    }

    open fun setupViewModel(baseViewModel: BaseViewModel) {
        this.baseViewModel = baseViewModel
    }


    open fun hideLoading() {
        if (mActivity != null) {
            mActivity?.hideLoading()
        }
    }

    open fun showLoading() {
        if (mActivity != null) {
            mActivity?.showLoading()
        }
    }

    open fun isLoading():Boolean? {
        if (mActivity != null) {
            return mActivity?.isLoading()
        }
        return null

    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewDataBinding.lifecycleOwner = this
        mViewDataBinding.executePendingBindings()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        observeViewModel()
        mActivity?.initLoaderObservable()
        mActivity?.initMessageObservable()
        super.onActivityCreated(savedInstanceState)
    }



    fun showToast(message: String) {
        mActivity?.showToast(message)
    }

    override fun onDetach() {
        mActivity = null
        super.onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
    fun getViewDataBinding(): T {
        return mViewDataBinding
    }


}
package com.example.mvvm_template.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_template.utils.SingleLiveEvent


abstract class BaseViewModel : ViewModel() {
//    private val _message: SingleLiveEvent<Message> = SingleLiveEvent()
//    val messageLiveDat:LiveData<Message> get() = _message
    private val _loader: SingleLiveEvent<Boolean> = SingleLiveEvent()
    val loaderLiveDat:LiveData<Boolean> get() = _loader
    private val _hideKeyboard: SingleLiveEvent<Void> = SingleLiveEvent()
    val hideKeyboardLiveDat:LiveData<Void> get() = _hideKeyboard
    private val _showNoInternetConnection: SingleLiveEvent<Void> = SingleLiveEvent()
    val showNoInternetConnectionLiveDat:LiveData<Void> get() = _showNoInternetConnection
    private val _showDefaultErrorMessage: SingleLiveEvent<Void> = SingleLiveEvent()
    val showDefaultErrorMessageLiveDat:LiveData<Void> get() = _showDefaultErrorMessage
    private val _dataLoadingEvent: SingleLiveEvent<Int> = SingleLiveEvent()
    val dataLoadingEvent: LiveData<Int> get() = _dataLoadingEvent

    fun setLoadingStatus(loadingStatus: Int){
        _dataLoadingEvent.value=loadingStatus

    }

    fun setLoading(loading: Boolean){
        _loader.value=loading
    }
}

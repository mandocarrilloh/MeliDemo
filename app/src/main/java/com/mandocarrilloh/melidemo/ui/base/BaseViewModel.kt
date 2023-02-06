package com.mandocarrilloh.melidemo.ui.base

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mandocarrilloh.melidemo.ui.extensions.asLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    /**
     * Events
     */

    protected val _loader = MutableLiveData<Boolean>()
    val loader get() = _loader.asLiveData()

    /**
     * Execute
     */

    protected fun execute(
        action: suspend () -> Unit
    ) = viewModelScope.launch(Dispatchers.Main) { action() }

    /**
     * Loading
     */

    protected fun hideLoading() {
        _loader.value = false
    }

    protected fun showLoading() {
        _loader.value = true
    }

    /**
     *
     */

    open fun onSaveInstanceState() = Bundle()

    open fun onRestoreInstanceState(savedInstanceState: Bundle) {}
}
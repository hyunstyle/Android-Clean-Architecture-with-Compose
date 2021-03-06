package com.hyunstyle.cleanarchitecture.presentation.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Created by hyunstyle on 2022.02.01
 * Copyright (c) 2022 All rights reserved.
 */
open class BaseViewModel : ViewModel() {

    private val tag = "BaseViewModel"

    val isProgressing = MutableLiveData<Boolean>()

    private val unknownErrorHandler = CoroutineExceptionHandler { _, throwable ->
        // exception handler
        Log.e(tag, "exception occurred!", throwable)
    }

    fun launch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(unknownErrorHandler) {
            block()
        }
    }
}
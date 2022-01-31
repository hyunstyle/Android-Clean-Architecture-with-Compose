package com.hyunstyle.cleanarchitecture.presentation.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hyunstyle.cleanarchitecture.domain.entity.CounterEntity
import com.hyunstyle.cleanarchitecture.domain.entity.CounterRequestEntity
import com.hyunstyle.cleanarchitecture.domain.usecase.CounterUseCase
import com.hyunstyle.cleanarchitecture.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

/**
 * Created by hyunstyle on 2022.02.01
 * Copyright (c) 2022 All rights reserved.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val counterUseCase: CounterUseCase
) : BaseViewModel() {

    private val _counter = MutableLiveData<CounterEntity>()
    val counter: LiveData<CounterEntity>
        get() = _counter

    fun visit(
        entity: CounterRequestEntity
    ) {
        isProgressing.value = true
        launch {
            val result = counterUseCase.execute(entity)
            // for compose progress indicator test
            delay(1500)

            isProgressing.value = false
            _counter.postValue(result)
        }
    }
}
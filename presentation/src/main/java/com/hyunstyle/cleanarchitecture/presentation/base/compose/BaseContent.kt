package com.hyunstyle.cleanarchitecture.presentation.base.compose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.hyunstyle.cleanarchitecture.presentation.base.BaseActivity
import com.hyunstyle.cleanarchitecture.presentation.base.BaseViewModel

/**
 * Created by hyunstyle on 2022.02.01
 * Copyright (c) 2022 All rights reserved.
 */
@Composable
fun <VM : BaseViewModel> BaseActivity<VM>.BaseTheme(
    content: @Composable () -> Unit
) {
    val isProgressing by mViewModel.isProgressing.observeAsState(false)
    MaterialTheme(
        colors = if(isSystemInDarkTheme()) {
            DarkColors
        } else {
            LightColors
        },
        content = content
    )
    ProgressIndicator(isDisplayed = isProgressing)
}
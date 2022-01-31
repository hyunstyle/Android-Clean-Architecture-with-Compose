package com.hyunstyle.cleanarchitecture.presentation.base

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hyunstyle.cleanarchitecture.presentation.base.compose.Red300

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    abstract val mViewModel: VM

    @Composable
    fun ProgressIndicator(isDisplayed: Boolean) {
        if(isDisplayed) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularProgressIndicator(
                    color = Red300
                )
            }
        }
    }

}
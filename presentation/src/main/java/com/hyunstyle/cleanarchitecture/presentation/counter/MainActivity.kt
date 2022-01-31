package com.hyunstyle.cleanarchitecture.presentation.counter

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hyunstyle.cleanarchitecture.domain.entity.CounterEntity
import com.hyunstyle.cleanarchitecture.domain.entity.CounterRequestEntity
import com.hyunstyle.cleanarchitecture.presentation.base.BaseActivity
import com.hyunstyle.cleanarchitecture.presentation.base.compose.BaseTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hyunstyle on 2022.02.01
 * Copyright (c) 2022 All rights reserved.
 */
@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel>() {

    override val mViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BaseTheme {
                Column(
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 50.dp)
                ) {
                    CounterKey()
                    Counter()
                }
            }
        }
    }

    @Composable
    fun CounterKey() {
        var text by remember {
            mutableStateOf("")
        }

        val focusRequester = remember {
            FocusRequester()
        }

        val focusManager = LocalFocusManager.current

        OutlinedTextField(
            value = text,
            textStyle = TextStyle(
                color = MaterialTheme.colors.onSurface,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp)
                .focusRequester(focusRequester = focusRequester),
            onValueChange = {
                text = it
            },
            singleLine = true,
            label = {
                Text("Please Enter Key")
            },
            placeholder = {
                Text("Example: test")
            },
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                    mViewModel.visit(CounterRequestEntity("test", text))
                }
            )
        )
        
        DisposableEffect(Unit) {
            focusRequester.requestFocus()
            onDispose {  }
        }
    }

    @Composable
    fun Counter(vm: MainViewModel = viewModel()) {
        val init = -1
        val counterEntity by vm.counter.observeAsState(
            initial = CounterEntity(init)
        )

        when(counterEntity.countValue) {
            init -> {

            }
            else -> {
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(
                            color = MaterialTheme.colors.onSurface,
                            fontSize = 18.sp)
                        ) {
                            append("your input key has been called")
                        }

                        withStyle(style = SpanStyle(
                            color = Color.Red,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold)
                        ) {
                            append(" ${counterEntity.countValue} ")
                        }

                        withStyle(style = SpanStyle(
                            color = MaterialTheme.colors.onSurface,
                            fontSize = 18.sp)
                        ) {
                            append("times.")
                        }
                    },
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(
                            color = MaterialTheme.colors.onSurface,
                            fontSize = 14.sp)
                        ) {
                            append("This count api is served by\n")
                        }

                        withStyle(style = SpanStyle(
                            color = Color.Red,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold)
                        ) {
                            append("https://countapi.xyz/")
                        }
                    },
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp)
                )
            }
        }
    }
}
package com.hyunstyle.cleanarchitecture.domain.entity

/**
 * Created by hyunstyle on 2022.02.01
 * Copyright (c) 2022 All rights reserved.
 */
data class CounterRequestEntity(
    val namespace: String,
    val key: String
)
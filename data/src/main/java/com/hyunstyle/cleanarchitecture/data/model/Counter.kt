package com.hyunstyle.cleanarchitecture.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by hyunstyle on 2022.02.01
 * Copyright (c) 2022 All rights reserved.
 */
@JsonClass(generateAdapter = true)
data class Counter(
    @Json(name = "value")
    val countValue: Int = 0
)
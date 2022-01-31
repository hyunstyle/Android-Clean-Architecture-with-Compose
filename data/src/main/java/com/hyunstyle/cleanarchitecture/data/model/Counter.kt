package com.hyunstyle.cleanarchitecture.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Counter(
    @Json(name = "value")
    val countValue: Int = 0
)
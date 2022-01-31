package com.hyunstyle.cleanarchitecture.domain.entity

data class CounterRequestEntity(
    val namespace: String,
    val key: String
)
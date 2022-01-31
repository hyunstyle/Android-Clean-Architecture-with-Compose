package com.hyunstyle.cleanarchitecture.data.base.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by hyunstyle on 2022.02.01
 * Copyright (c) 2022 All rights reserved.
 */
inline fun <reified T : BaseApiService> create(domain: ApiDomains) : T {
    val retrofit = Retrofit.Builder()
        .baseUrl(domain.baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    return retrofit.create(T::class.java)
}
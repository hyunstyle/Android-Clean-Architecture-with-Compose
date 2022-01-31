package com.hyunstyle.cleanarchitecture.data.base.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

inline fun <reified T : BaseApiService> create(domain: ApiDomains) : T {
    val retrofit = Retrofit.Builder()
        .baseUrl(domain.baseUrl)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    return retrofit.create(T::class.java)
}
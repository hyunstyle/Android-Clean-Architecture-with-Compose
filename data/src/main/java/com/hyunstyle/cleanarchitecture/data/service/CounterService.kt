package com.hyunstyle.cleanarchitecture.data.service

import com.hyunstyle.cleanarchitecture.data.base.api.BaseApiService
import com.hyunstyle.cleanarchitecture.data.model.Counter
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by hyunstyle on 2022.02.01
 * Copyright (c) 2022 All rights reserved.
 */
interface CounterService : BaseApiService {

    @GET("hit/{namespace}/{key}")
    suspend fun visit(@Path("namespace") namespace: String, @Path("key") key: String) : Counter
}
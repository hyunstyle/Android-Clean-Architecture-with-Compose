package com.hyunstyle.cleanarchitecture.data.service

import com.hyunstyle.cleanarchitecture.data.base.api.BaseApiService
import com.hyunstyle.cleanarchitecture.data.model.Counter
import retrofit2.http.GET
import retrofit2.http.Path

interface CounterService : BaseApiService {

    @GET("hit/{namespace}/{key}")
    suspend fun visit(@Path("namespace") namespace: String, @Path("key") key: String) : Counter
}
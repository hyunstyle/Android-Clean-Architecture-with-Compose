package com.hyunstyle.cleanarchitecture.domain.usecase

/**
 * Created by hyunstyle on 2022.02.01
 * Copyright (c) 2022 All rights reserved.
 */
interface BaseUseCase<in P, out R> {
    suspend fun execute(param: P) : R
}
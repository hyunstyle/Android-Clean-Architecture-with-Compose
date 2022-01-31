package com.hyunstyle.cleanarchitecture.domain.repository

import com.hyunstyle.cleanarchitecture.domain.entity.CounterEntity
import com.hyunstyle.cleanarchitecture.domain.entity.CounterRequestEntity

/**
 * Created by hyunstyle on 2022.02.01
 * Copyright (c) 2022 All rights reserved.
 */
interface CounterRepository {
    suspend fun getCount(entity: CounterRequestEntity) : CounterEntity
}
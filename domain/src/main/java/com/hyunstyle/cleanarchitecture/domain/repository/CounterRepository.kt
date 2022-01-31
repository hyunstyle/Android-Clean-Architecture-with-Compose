package com.hyunstyle.cleanarchitecture.domain.repository

import com.hyunstyle.cleanarchitecture.domain.entity.CounterEntity
import com.hyunstyle.cleanarchitecture.domain.entity.CounterRequestEntity

interface CounterRepository {
    suspend fun getCount(entity: CounterRequestEntity) : CounterEntity
}
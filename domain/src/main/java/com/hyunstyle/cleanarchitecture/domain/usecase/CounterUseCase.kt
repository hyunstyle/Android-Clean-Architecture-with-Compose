package com.hyunstyle.cleanarchitecture.domain.usecase

import com.hyunstyle.cleanarchitecture.domain.entity.CounterEntity
import com.hyunstyle.cleanarchitecture.domain.entity.CounterRequestEntity
import com.hyunstyle.cleanarchitecture.domain.repository.CounterRepository
import javax.inject.Inject

/**
 * Created by hyunstyle on 2022.02.01
 * Copyright (c) 2022 All rights reserved.
 */
class CounterUseCase @Inject constructor(
    private val repository: CounterRepository
) : BaseUseCase<CounterRequestEntity, CounterEntity> {

    override suspend fun execute(param: CounterRequestEntity) : CounterEntity {
        return repository.getCount(param)
    }
}
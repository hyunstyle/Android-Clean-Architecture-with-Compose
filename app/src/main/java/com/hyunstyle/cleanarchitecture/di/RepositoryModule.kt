package com.hyunstyle.cleanarchitecture.di

import com.hyunstyle.cleanarchitecture.data.repository.CounterRepositoryImpl
import com.hyunstyle.cleanarchitecture.domain.repository.CounterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by hyunstyle on 2022.02.01
 * Copyright (c) 2022 All rights reserved.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindCounterRepository(repository: CounterRepositoryImpl) : CounterRepository
}
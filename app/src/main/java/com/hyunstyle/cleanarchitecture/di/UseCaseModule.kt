package com.hyunstyle.cleanarchitecture.di

import com.hyunstyle.cleanarchitecture.domain.repository.CounterRepository
import com.hyunstyle.cleanarchitecture.domain.usecase.CounterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by hyunstyle on 2022.02.01
 * Copyright (c) 2022 All rights reserved.
 */
@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideUseCase(repository: CounterRepository) = CounterUseCase(repository)
}
package com.hyunstyle.cleanarchitecture.di

import com.hyunstyle.cleanarchitecture.domain.repository.CounterRepository
import com.hyunstyle.cleanarchitecture.domain.usecase.CounterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideUseCase(repository: CounterRepository) = CounterUseCase(repository)
}
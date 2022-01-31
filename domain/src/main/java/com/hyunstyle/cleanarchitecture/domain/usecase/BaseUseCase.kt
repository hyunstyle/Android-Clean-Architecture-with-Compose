package com.hyunstyle.cleanarchitecture.domain.usecase

interface BaseUseCase<in P, out R> {
    suspend fun execute(param: P) : R
}
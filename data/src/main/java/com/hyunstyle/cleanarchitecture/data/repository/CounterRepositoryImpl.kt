package com.hyunstyle.cleanarchitecture.data.repository


import com.hyunstyle.cleanarchitecture.data.base.api.ApiDomains
import com.hyunstyle.cleanarchitecture.data.base.api.create
import com.hyunstyle.cleanarchitecture.data.service.CounterService
import com.hyunstyle.cleanarchitecture.domain.entity.CounterEntity
import com.hyunstyle.cleanarchitecture.domain.entity.CounterRequestEntity
import com.hyunstyle.cleanarchitecture.domain.repository.CounterRepository
import javax.inject.Inject

class CounterRepositoryImpl @Inject constructor() : CounterRepository {
    override suspend fun getCount(entity: CounterRequestEntity) : CounterEntity {
        val counter = create<CounterService>(ApiDomains.Counter).visit(entity.namespace, entity.key)
        return CounterEntity(counter.countValue)
    }
}
package com.arhelicortes.catfact_dagger.data.repository

import com.arhelicortes.catfact_dagger.data.model.fact.CatFactResponse
import com.arhelicortes.catfact_dagger.domain.datasource.CatFactDataSource
import com.arhelicortes.catfact_dagger.domain.model.fact.CatFactDto
import com.arhelicortes.catfact_dagger.domain.repository.CatFactRepository
import com.arhelicortes.catfact_dagger.domain.util.EntityMapper
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CatFactDataRepository @Inject constructor(
    private val catFactNetworkData: CatFactDataSource,
    private val catFactMapper: EntityMapper<CatFactResponse, CatFactDto>
): CatFactRepository {
    override fun getCatFactData(): Single<CatFactDto> {
        return catFactNetworkData.getCatFacts().map {
            catFactMapper.transform(it)
        }.onErrorResumeNext{
            Single.error(it)
        }
    }
}
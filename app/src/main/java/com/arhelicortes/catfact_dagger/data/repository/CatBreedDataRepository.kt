package com.arhelicortes.catfact_dagger.data.repository

import com.arhelicortes.catfact_dagger.data.model.breed.CatBreadResponse
import com.arhelicortes.catfact_dagger.domain.datasource.CatBreadDataSource
import com.arhelicortes.catfact_dagger.domain.model.bread.CatBreadDto
import com.arhelicortes.catfact_dagger.domain.repository.CatBreedRepository
import com.arhelicortes.catfact_dagger.domain.util.EntityMapper
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CatBreedDataRepository @Inject constructor(
    private val catBreadNetworkDataSource: CatBreadDataSource,
    private val catBreadMapper: EntityMapper<CatBreadResponse, CatBreadDto>,
): CatBreedRepository {
    override fun getCatBreadData(): Single<CatBreadDto> {
        return catBreadNetworkDataSource.getCatBreads()
            .map { catBreadResponse->
                catBreadMapper.transform(catBreadResponse)
            }.onErrorResumeNext {
                Single.error(it)
            }
    }
}
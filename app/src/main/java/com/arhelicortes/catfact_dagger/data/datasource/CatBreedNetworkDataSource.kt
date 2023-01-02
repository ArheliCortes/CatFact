package com.arhelicortes.catfact_dagger.data.datasource

import com.arhelicortes.catfact_dagger.data.model.breed.CatBreadResponse
import com.arhelicortes.catfact_dagger.data.service.CatBreadService
import com.arhelicortes.catfact_dagger.domain.datasource.CatBreadDataSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CatBreedNetworkDataSource @Inject constructor(
    private val catBreadService: CatBreadService,
): CatBreadDataSource {

    override fun getCatBreads(): Single<CatBreadResponse> {
        return catBreadService.getCatBreads().map {
            it.body() ?: throw Exception(it.message())
        }.onErrorResumeNext {
            throw Exception(it.cause)
        }
    }
}
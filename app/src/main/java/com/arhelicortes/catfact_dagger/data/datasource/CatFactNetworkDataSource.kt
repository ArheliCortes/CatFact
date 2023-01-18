package com.arhelicortes.catfact_dagger.data.datasource

import com.arhelicortes.catfact_dagger.data.model.fact.CatFactResponse
import com.arhelicortes.catfact_dagger.data.service.CatFactService
import com.arhelicortes.catfact_dagger.domain.datasource.CatFactDataSource
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CatFactNetworkDataSource(
    private val catFactService: CatFactService,
): CatFactDataSource {
    override fun getCatFacts(): Single<CatFactResponse> {
        return catFactService.getCatFacts().map { catFactResponse ->
            if (catFactResponse.isSuccessful) {
                catFactResponse.body() ?: throw Exception(catFactResponse.message())
            } else {
                throw Exception(catFactResponse.message())
            }
        }
    }
}

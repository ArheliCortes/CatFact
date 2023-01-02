package com.arhelicortes.catfact_dagger.domain.datasource

import com.arhelicortes.catfact_dagger.data.model.breed.CatBreadResponse
import io.reactivex.rxjava3.core.Single

interface CatBreadDataSource {
    fun getCatBreads(): Single<CatBreadResponse>
}
package com.arhelicortes.catfact_dagger.domain.datasource

import com.arhelicortes.catfact_dagger.data.model.fact.CatFactResponse
import io.reactivex.rxjava3.core.Single

interface CatFactDataSource {
    fun getCatFacts(): Single<CatFactResponse>
}
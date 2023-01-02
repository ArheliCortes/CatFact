package com.arhelicortes.catfact_dagger.domain.usecase

import com.arhelicortes.catfact_dagger.domain.model.fact.CatFactDataDto
import io.reactivex.rxjava3.core.Single

interface CatFactListUseCase {
    fun getCatFacts(): Single<List<CatFactDataDto>>
}
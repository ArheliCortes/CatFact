package com.arhelicortes.catfact_dagger.domain.repository

import com.arhelicortes.catfact_dagger.domain.model.fact.CatFactDto
import io.reactivex.rxjava3.core.Single

interface CatFactRepository {
    fun getCatFactData(): Single<CatFactDto>
}
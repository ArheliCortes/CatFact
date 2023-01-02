package com.arhelicortes.catfact_dagger.domain.repository

import com.arhelicortes.catfact_dagger.domain.model.bread.CatBreadDto
import io.reactivex.rxjava3.core.Single

interface CatBreedRepository {
    fun getCatBreadData(): Single<CatBreadDto>
}
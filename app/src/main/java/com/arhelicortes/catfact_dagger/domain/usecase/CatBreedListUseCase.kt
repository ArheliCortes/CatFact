package com.arhelicortes.catfact_dagger.domain.usecase

import com.arhelicortes.catfact_dagger.domain.model.bread.CatBreedDataDto
import io.reactivex.rxjava3.core.Single

interface CatBreedListUseCase {
    fun getCatBreeds(): Single<List<CatBreedDataDto>>
}
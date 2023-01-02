package com.arhelicortes.catfact_dagger.domain.usecase

import com.arhelicortes.catfact_dagger.domain.model.bread.CatBreadDto
import com.arhelicortes.catfact_dagger.domain.model.bread.CatBreedDataDto
import com.arhelicortes.catfact_dagger.domain.repository.CatBreedRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CatBreedsUseCase @Inject constructor(
    private val catBreedRepository: CatBreedRepository,
): CatBreedListUseCase {
    operator fun invoke(): Single<CatBreadDto> {
        return catBreedRepository.getCatBreadData()
    }
    override fun getCatBreeds(): Single<List<CatBreedDataDto>> {
        return catBreedRepository.getCatBreadData().map { it.data }
    }
}
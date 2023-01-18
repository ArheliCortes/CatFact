package com.arhelicortes.catfact_dagger.domain.usecase

import com.arhelicortes.catfact_dagger.domain.model.fact.CatFactDataDto
import com.arhelicortes.catfact_dagger.domain.repository.CatFactRepository
import io.reactivex.rxjava3.core.Single

class CatFactUseCase (
    private val catFactRepository: CatFactRepository,
): CatFactListUseCase {
    override fun getCatFacts(): Single<List<CatFactDataDto>> {
        return catFactRepository.getCatFactData().map { it.data }
    }
}
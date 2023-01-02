package com.arhelicortes.catfact_dagger.domain.di

import com.arhelicortes.catfact_dagger.data.repository.CatBreedDataRepository
import com.arhelicortes.catfact_dagger.data.repository.CatFactDataRepository
import com.arhelicortes.catfact_dagger.domain.repository.CatBreedRepository
import com.arhelicortes.catfact_dagger.domain.repository.CatFactRepository
import com.arhelicortes.catfact_dagger.domain.usecase.CatBreedListUseCase
import com.arhelicortes.catfact_dagger.domain.usecase.CatBreedsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CatBreedDomainModule {
    @Binds
    abstract fun provideCatBreedRepository(
        catBreedDataRepository: CatBreedDataRepository
    ): CatBreedRepository

    @Binds
    abstract fun provideCatBreedListUseCase(
        catBreedListUseCase: CatBreedsUseCase
    ): CatBreedListUseCase

    @Binds
    abstract fun provideCatFactRepository(
        catFactRepository: CatFactDataRepository
    ): CatFactRepository

}
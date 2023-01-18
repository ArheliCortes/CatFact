package com.arhelicortes.catfact_dagger.di

import com.arhelicortes.catfact_dagger.data.datasource.CatBreedNetworkDataSource
import com.arhelicortes.catfact_dagger.data.repository.CatBreedDataRepository
import com.arhelicortes.catfact_dagger.domain.datasource.CatBreadDataSource
import com.arhelicortes.catfact_dagger.domain.repository.CatBreedRepository
import com.arhelicortes.catfact_dagger.domain.usecase.CatBreedListUseCase
import com.arhelicortes.catfact_dagger.domain.usecase.CatBreedsUseCase
import com.arhelicortes.catfact_dagger.presentation.contract.CatBreedContract
import com.arhelicortes.catfact_dagger.presentation.view.fragment.BreedListFragment
import dagger.Binds
import dagger.Module

@Module
abstract class CatBreedModule {
    @Binds
    abstract fun provideCatUseCase(catUseCase: CatBreedsUseCase): CatBreedListUseCase

    @Binds
    abstract fun provideCatRepository(catRepository: CatBreedDataRepository): CatBreedRepository

    @Binds
    abstract fun provideCatDataSource(catDataSource: CatBreedNetworkDataSource): CatBreadDataSource
}
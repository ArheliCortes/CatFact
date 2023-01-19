package com.arhelicortes.catfact_dagger.di

import com.arhelicortes.catfact_dagger.data.datasource.CatFactNetworkDataSource
import com.arhelicortes.catfact_dagger.data.repository.CatFactDataRepository
import com.arhelicortes.catfact_dagger.domain.datasource.CatFactDataSource
import com.arhelicortes.catfact_dagger.domain.repository.CatFactRepository

import dagger.Binds
import dagger.Module

@Module
abstract class CatFactModule {
    @Binds
    abstract fun bindCatFactRepository(catFactRepository: CatFactDataRepository): CatFactRepository

    @Binds
    abstract fun bindCatFactDataSource(catFactDataSource: CatFactNetworkDataSource): CatFactDataSource
}
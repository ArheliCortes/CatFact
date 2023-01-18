package com.arhelicortes.catfact_dagger.di

import com.arhelicortes.catfact_dagger.data.mapper.CatLinkMapper
import com.arhelicortes.catfact_dagger.data.mapper.breed.CatBreedDataMapper
import com.arhelicortes.catfact_dagger.data.mapper.breed.CatBreedMapper
import com.arhelicortes.catfact_dagger.data.mapper.fact.CatFactDataMapper
import com.arhelicortes.catfact_dagger.data.mapper.fact.CatFactMapper
import com.arhelicortes.catfact_dagger.data.model.CatLinkEntity
import com.arhelicortes.catfact_dagger.data.model.breed.CatBreadDataEntity
import com.arhelicortes.catfact_dagger.data.model.breed.CatBreadResponse
import com.arhelicortes.catfact_dagger.data.model.fact.CatFactDataEntity
import com.arhelicortes.catfact_dagger.data.model.fact.CatFactResponse
import com.arhelicortes.catfact_dagger.domain.model.CatLinkDto
import com.arhelicortes.catfact_dagger.domain.model.bread.CatBreadDto
import com.arhelicortes.catfact_dagger.domain.model.bread.CatBreedDataDto
import com.arhelicortes.catfact_dagger.domain.model.fact.CatFactDataDto
import com.arhelicortes.catfact_dagger.domain.model.fact.CatFactDto
import com.arhelicortes.catfact_dagger.domain.util.EntityMapper
import dagger.Module
import dagger.Provides

@Module
object MapperModule {
    @Provides
    fun provideCatBreedMapper(
        catBreedDataMapper: CatBreedDataMapper,
        catLinkMapper: CatLinkMapper
    ) : EntityMapper<CatBreadResponse, CatBreadDto> =
        CatBreedMapper(catBreedDataMapper, catLinkMapper)

    @Provides
    fun provideCatFactMapper(
        catFactDataMapper: CatFactDataMapper,
        catLinkMapper: CatLinkMapper,
    ): EntityMapper<CatFactResponse, CatFactDto> =
        CatFactMapper(catFactDataMapper, catLinkMapper)

    @Provides
    fun provideCatLinkMapper(): EntityMapper<CatLinkEntity, CatLinkDto> = CatLinkMapper()

    @Provides
    fun provideCatBreedDataMapper(): EntityMapper<CatBreadDataEntity, CatBreedDataDto> = CatBreedDataMapper()

    @Provides
    fun provideCatFactDataMapper(): EntityMapper<CatFactDataEntity, CatFactDataDto> = CatFactDataMapper()

}
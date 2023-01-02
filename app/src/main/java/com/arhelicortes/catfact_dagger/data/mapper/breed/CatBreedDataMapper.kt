package com.arhelicortes.catfact_dagger.data.mapper.breed

import com.arhelicortes.catfact_dagger.data.model.breed.CatBreadDataEntity
import com.arhelicortes.catfact_dagger.domain.model.bread.CatBreedDataDto
import com.arhelicortes.catfact_dagger.domain.util.EntityMapper
import javax.inject.Inject

class CatBreedDataMapper @Inject constructor(): EntityMapper<CatBreadDataEntity, CatBreedDataDto>() {
    override fun transform(entity: CatBreadDataEntity): CatBreedDataDto {
        return CatBreedDataDto(
            breed = entity.bread ?: "",
            country = entity.country ?: "",
            origin = entity.origin ?: "",
            coat = entity.coat ?: "",
            pattern = entity.pattern ?: "",
        )
    }
}
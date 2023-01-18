package com.arhelicortes.catfact_dagger.data.mapper.breed

import com.arhelicortes.catfact_dagger.data.model.breed.CatBreadDataEntity
import com.arhelicortes.catfact_dagger.data.model.CatLinkEntity
import com.arhelicortes.catfact_dagger.data.model.breed.CatBreadResponse
import com.arhelicortes.catfact_dagger.domain.model.bread.CatBreedDataDto
import com.arhelicortes.catfact_dagger.domain.model.bread.CatBreadDto
import com.arhelicortes.catfact_dagger.domain.model.CatLinkDto
import com.arhelicortes.catfact_dagger.domain.util.EntityMapper
import javax.inject.Inject

class CatBreedMapper @Inject constructor(
    private val dataBreadMapper: EntityMapper<CatBreadDataEntity, CatBreedDataDto>,
    private val linkBreadMapper: EntityMapper<CatLinkEntity, CatLinkDto>,
) : EntityMapper<CatBreadResponse, CatBreadDto>() {
    override fun transform(entity: CatBreadResponse): CatBreadDto {
       return CatBreadDto(
           currentPage = entity.currentPage ?: 0,
           data = dataBreadMapper.transformCollection(entity.data ?: emptyList()),
           firstPageUrl = entity.firstPageUrl ?: "",
           fromPage = entity.fromPage ?: 0,
           lastPage = entity.lastPage ?: 0,
           lastPageUrl = entity.lastPageUrl ?: "",
           links = linkBreadMapper.transformCollection(entity.links ?: emptyList()),
           nextPageUrl = entity.nextPageUrl ?: "",
           currentPath = entity.currentPath ?: "",
           perPage = entity.perPage ?: 0,
           prevPageUrl = entity.prevPageUrl ?: "",
           toPage = entity.toPage ?: 0,
           total = entity.total ?: 0,
       )
    }
}
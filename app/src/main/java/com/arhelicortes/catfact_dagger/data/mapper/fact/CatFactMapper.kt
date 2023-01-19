package com.arhelicortes.catfact_dagger.data.mapper.fact

import com.arhelicortes.catfact_dagger.data.model.CatLinkEntity
import com.arhelicortes.catfact_dagger.data.model.fact.CatFactDataEntity
import com.arhelicortes.catfact_dagger.data.model.fact.CatFactResponse
import com.arhelicortes.catfact_dagger.domain.model.CatLinkDto
import com.arhelicortes.catfact_dagger.domain.model.fact.CatFactDataDto
import com.arhelicortes.catfact_dagger.domain.model.fact.CatFactDto
import com.arhelicortes.catfact_dagger.domain.util.EntityMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CatFactMapper @Inject constructor(
    private val factDataMapper: EntityMapper<CatFactDataEntity, CatFactDataDto>,
    private val linkBreadMapper: EntityMapper<CatLinkEntity, CatLinkDto>,
): EntityMapper<CatFactResponse, CatFactDto>() {
    override fun transform(entity: CatFactResponse): CatFactDto {
        return with(entity) {
            CatFactDto(
                currentPage = currentPage ?: 0,
                data = factDataMapper.transformCollection(catFacts ?: emptyList()),
                firstPageUrl = firstPageUrl ?: "",
                fromPage = fromPage ?: 0,
                lastPage = lastPage ?: 0,
                lastPageUrl = lastPageUrl ?: "",
                links = linkBreadMapper.transformCollection(links ?: emptyList()),
                nextPageUrl = entity.nextPageUrl ?: "",
                currentPath = entity.currentPath ?: "",
                perPage = entity.perPage ?: 0,
                prevPageUrl = entity.prevPageUrl ?: "",
                toPage = entity.toPage ?: 0,
                total = entity.total ?: 0,
            )
        }
    }
}
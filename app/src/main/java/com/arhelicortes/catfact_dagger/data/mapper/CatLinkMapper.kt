package com.arhelicortes.catfact_dagger.data.mapper

import com.arhelicortes.catfact_dagger.data.model.CatLinkEntity
import com.arhelicortes.catfact_dagger.domain.model.CatLinkDto
import com.arhelicortes.catfact_dagger.domain.util.EntityMapper
import javax.inject.Inject

class CatLinkMapper @Inject constructor(): EntityMapper<CatLinkEntity, CatLinkDto>() {
    override fun transform(entity: CatLinkEntity): CatLinkDto {
        return CatLinkDto(
            url = entity.url ?: "",
            label = entity.label ?: "",
            active = entity.active,
        )
    }
}
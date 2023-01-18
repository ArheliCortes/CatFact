package com.arhelicortes.catfact_dagger.data.mapper.fact

import com.arhelicortes.catfact_dagger.data.model.fact.CatFactDataEntity
import com.arhelicortes.catfact_dagger.domain.model.fact.CatFactDataDto
import com.arhelicortes.catfact_dagger.domain.util.EntityMapper
import javax.inject.Inject

class CatFactDataMapper: EntityMapper<CatFactDataEntity, CatFactDataDto>() {
    override fun transform(entity: CatFactDataEntity): CatFactDataDto {
        return with(entity) {
            CatFactDataDto(
                fact = fact ?: "",
                length = factLength ?: 0
            )
        }
    }
}
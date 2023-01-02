package com.arhelicortes.catfact_dagger.domain.util

abstract class EntityMapper <E1, E2> {
    abstract fun transform(entity: E1): E2
    fun transformCollection(entities: List<E1>) = entities.map { entity-> transform(entity) }
}
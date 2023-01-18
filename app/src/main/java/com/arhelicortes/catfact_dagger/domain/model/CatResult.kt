package com.arhelicortes.catfact_dagger.domain.model

sealed class CatResult<out T: Any> {
    data class Success<out T: Any>(val data: T) : CatResult<T>()
    data class Error(val exception: String): CatResult<Nothing>()
}

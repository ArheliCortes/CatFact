package com.arhelicortes.catfact_dagger.domain.model.bread

import com.arhelicortes.catfact_dagger.domain.model.CatLinkDto


data class CatBreadDto(
    val currentPage: Int = 0,
    val data: List<CatBreedDataDto> = emptyList(),
    val firstPageUrl: String = "",
    val fromPage: Int = 0,
    val lastPage: Int = 0,
    val lastPageUrl: String = "",
    val links: List<CatLinkDto> = emptyList(),
    val nextPageUrl: String = "",
    val currentPath: String = "",
    val perPage: Int = 0,
    val prevPageUrl: String = "",
    val toPage: Int = 0,
    val total: Int = 0,
)
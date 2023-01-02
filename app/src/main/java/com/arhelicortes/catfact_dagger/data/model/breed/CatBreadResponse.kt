package com.arhelicortes.catfact_dagger.data.model.breed

import com.arhelicortes.catfact_dagger.data.model.CatLinkEntity
import com.google.gson.annotations.SerializedName
import java.util.Collections.emptyList

data class CatBreadResponse(
    @SerializedName("current_page")
    val currentPage: Int? = null,
    @SerializedName("data")
    val data: List<CatBreadDataEntity>? = emptyList(),
    @SerializedName("first_page_url")
    val firstPageUrl: String? = null,
    @SerializedName("from")
    val fromPage: Int? = null,
    @SerializedName("last_page")
    val lastPage: Int? = null,
    @SerializedName("last_page_url")
    val lastPageUrl: String? = null,
    @SerializedName("links")
    val links: List<CatLinkEntity>? = emptyList(),
    @SerializedName("next_page_url")
    val nextPageUrl: String? = null,
    @SerializedName("path")
    val currentPath: String? = null,
    @SerializedName("per_page")
    val perPage: Int? = null,
    @SerializedName("prev_page_url")
    val prevPageUrl: String? = null,
    @SerializedName("to")
    val toPage: Int? = null,
    @SerializedName("total")
    val total: Int? = null,
)

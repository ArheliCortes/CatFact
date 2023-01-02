package com.arhelicortes.catfact_dagger.data.model

import com.google.gson.annotations.SerializedName

data class CatLinkEntity(
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("label")
    val label: String? = null,
    @SerializedName("active")
    val active: Boolean = false,
)

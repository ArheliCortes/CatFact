package com.arhelicortes.catfact_dagger.data.model.breed

import com.google.gson.annotations.SerializedName

data class CatBreadDataEntity(
    @SerializedName("breed")
    val bread: String? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("origin")
    val origin: String? = null,
    @SerializedName("coat")
    val coat: String? = null,
    @SerializedName("pattern")
    val pattern: String? = null,
)

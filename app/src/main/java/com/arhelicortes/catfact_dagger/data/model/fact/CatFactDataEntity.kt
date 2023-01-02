package com.arhelicortes.catfact_dagger.data.model.fact

import com.google.gson.annotations.SerializedName

data class CatFactDataEntity(
    @SerializedName("fact")
    val fact: String? = null,
    @SerializedName("length")
    val factLength: Int? = null,
)

package com.arhelicortes.catfact_dagger.domain.model.bread

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatBreedDataDto(
    var breed: String = "",
    var country: String = "",
    var origin: String = "",
    var coat: String = "",
    var pattern: String = "",
) : Parcelable

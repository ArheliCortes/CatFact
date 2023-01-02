package com.arhelicortes.catfact_dagger.data.service

import com.arhelicortes.catfact_dagger.data.model.breed.CatBreadResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET

interface CatBreadService {
    @GET("https://catfact.ninja/breeds")
    fun getCatBreads(): Single<Response<CatBreadResponse>>
}
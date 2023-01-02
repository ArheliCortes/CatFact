package com.arhelicortes.catfact_dagger.data.service

import com.arhelicortes.catfact_dagger.data.model.fact.CatFactResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET

interface CatFactService {
    @GET("https://catfact.ninja/facts")
    fun getCatFacts(): Single<Response<CatFactResponse>>
}
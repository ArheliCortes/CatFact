package com.arhelicortes.catfact_dagger.di

import com.arhelicortes.catfact_dagger.data.service.CatBreadService
import com.arhelicortes.catfact_dagger.data.service.CatFactService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
object NetworkModule {
    @Provides
    fun provideCatBreedService(retrofit: Retrofit): CatBreadService =
        retrofit.create(CatBreadService::class.java)

    @Provides
    fun provideCatFactService(retrofit: Retrofit): CatFactService =
        retrofit.create(CatFactService::class.java)

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    private const val BASE_URL = "https://catfact.ninja/"
}
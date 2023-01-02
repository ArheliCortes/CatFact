package com.arhelicortes.catfact_dagger.data.di.module

import com.arhelicortes.catfact_dagger.data.datasource.CatBreedNetworkDataSource
import com.arhelicortes.catfact_dagger.data.datasource.CatFactNetworkDataSource
import com.arhelicortes.catfact_dagger.data.service.CatBreadService
import com.arhelicortes.catfact_dagger.data.service.CatFactService
import com.arhelicortes.catfact_dagger.domain.datasource.CatBreadDataSource
import com.arhelicortes.catfact_dagger.domain.datasource.CatFactDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideCatFactService(retrofit: Retrofit) = retrofit.create(CatFactService::class.java)


    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient) =
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

    @Provides
    @Singleton
    fun provideCatFactNetworkDataSource(catFactService: CatFactService): CatFactDataSource {
        return CatFactNetworkDataSource(catFactService)
    }

    @Provides
    @Singleton
    fun provideCatNetworkDataSource(catBreedService: CatBreadService): CatBreadDataSource =
        CatBreedNetworkDataSource(catBreedService)
    @Provides
    @Singleton
    fun provideCatBreedService(retrofit: Retrofit) = retrofit.create(CatBreadService::class.java)


    private const val BASE_URL = "https://catfact.ninja/"
}
package com.arhelicortes.catfact_dagger.data.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object RxModule {
    @Provides
    @Named(SCHEDULER_MAIN_THREAD)
    fun provideAndroidMainThreadScheduler() : Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @Named(SCHEDULER_IO)
    fun provideIoScheduler() : Scheduler = Schedulers.io()

    const val SCHEDULER_MAIN_THREAD = "mainThread"
    const val SCHEDULER_IO = "io"
}
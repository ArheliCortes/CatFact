package com.arhelicortes.catfact_dagger

import android.app.Application
import com.arhelicortes.catfact_dagger.di.AppComponent
import com.arhelicortes.catfact_dagger.di.DaggerAppComponent

class CatFactApp: Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create()
    }
}
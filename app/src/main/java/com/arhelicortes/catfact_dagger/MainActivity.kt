package com.arhelicortes.catfact_dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arhelicortes.catfact_dagger.di.AppComponent

class MainActivity : AppCompatActivity() {

    lateinit var appComponent: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent = (application as CatFactApp).appComponent
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
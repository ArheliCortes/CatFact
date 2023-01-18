package com.arhelicortes.catfact_dagger.di

import com.arhelicortes.catfact_dagger.MainActivity
import com.arhelicortes.catfact_dagger.presentation.view.fragment.BreedListFragment
import com.arhelicortes.catfact_dagger.presentation.view.fragment.FactListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CatBreedModule::class,
        MapperModule::class,
        NetworkModule::class,
        RxJavaModule::class,
        FragmentModule::class,
        ViewModelModule::class,
        ViewModelFactoryModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create() : AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: BreedListFragment)
    fun inject(fragment: FactListFragment)
}
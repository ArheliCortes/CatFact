package com.arhelicortes.catfact_dagger.di

import androidx.lifecycle.ViewModel
import com.arhelicortes.catfact_dagger.presentation.viewmodel.CatBreedViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(CatBreedViewModel::class)
    abstract fun bindCatBreedViewModel(viewModel: CatBreedViewModel): ViewModel
}
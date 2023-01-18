package com.arhelicortes.catfact_dagger.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlin.reflect.KClass

class ViewModelFactory<T: ViewModel>(
    private val viewModelClass: KClass<T>,
    val constructor: () -> T
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(viewModelClass.java)) {
            return constructor as T
        }
        throw IllegalArgumentException("model class is not assignable from ViewModel")
    }
}
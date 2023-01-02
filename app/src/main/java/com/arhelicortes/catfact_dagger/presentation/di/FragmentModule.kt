package com.arhelicortes.catfact_dagger.presentation.di

import androidx.fragment.app.Fragment
import com.arhelicortes.catfact_dagger.presentation.view.fragment.BreedListFragment
import com.arhelicortes.catfact_dagger.presentation.view.fragment.FactListFragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module
object FragmentModule {
    @Provides
    fun bindFragment(fragment: Fragment): BreedListFragment = fragment as BreedListFragment

    @Provides
    fun bindFactFragment(fragment: Fragment): FactListFragment = fragment as FactListFragment

}
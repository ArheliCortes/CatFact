package com.arhelicortes.catfact_dagger.di

import androidx.fragment.app.Fragment
import com.arhelicortes.catfact_dagger.presentation.view.fragment.BreedListFragment
import dagger.Module
import dagger.Provides

@Module
object FragmentModule {
    @Provides
    fun bindFragment(fragment: Fragment): BreedListFragment = fragment as BreedListFragment
}
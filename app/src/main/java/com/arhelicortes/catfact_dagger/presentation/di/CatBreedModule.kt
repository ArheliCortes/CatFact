package com.arhelicortes.catfact_dagger.presentation.di

import com.arhelicortes.catfact_dagger.presentation.contract.CatBreedContract
import com.arhelicortes.catfact_dagger.presentation.contract.CatFactContract
import com.arhelicortes.catfact_dagger.presentation.presenter.CatBreedPresenter
import com.arhelicortes.catfact_dagger.presentation.presenter.CatFactPresenter
import com.arhelicortes.catfact_dagger.presentation.view.fragment.BreedListFragment
import com.arhelicortes.catfact_dagger.presentation.view.fragment.FactListFragment
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module
abstract class CatBreedModule {
    @Binds
    abstract fun bindView(view: BreedListFragment): CatBreedContract.View

    @Binds
    abstract fun bindPresenter(presenter: CatBreedPresenter): CatBreedContract.Presenter

    @Binds
    abstract fun viewFact(view: FactListFragment): CatFactContract.View

    @Binds
    abstract fun presenter(presenter: CatFactPresenter): CatFactContract.Presenter

}
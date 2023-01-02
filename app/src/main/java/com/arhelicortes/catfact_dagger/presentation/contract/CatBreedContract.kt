package com.arhelicortes.catfact_dagger.presentation.contract

import com.arhelicortes.catfact_dagger.domain.model.bread.CatBreedDataDto

interface CatBreedContract {
    interface View {
        fun showErrorMessage(message: String)
        fun onCatBreedListReceived(catBreeds: List<CatBreedDataDto>)
    }
    interface Presenter {
        fun onViewCreated()
        fun onDestroyView()
    }
}
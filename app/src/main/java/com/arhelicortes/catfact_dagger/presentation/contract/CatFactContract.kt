package com.arhelicortes.catfact_dagger.presentation.contract

import com.arhelicortes.catfact_dagger.domain.model.fact.CatFactDataDto

interface CatFactContract {
    interface View {
        fun showErrorMessage(message: String)
        fun showCatFactList(catFacts: List<CatFactDataDto>)

    }

    interface Presenter {
        fun initData()
        fun onDestroy()
    }
}
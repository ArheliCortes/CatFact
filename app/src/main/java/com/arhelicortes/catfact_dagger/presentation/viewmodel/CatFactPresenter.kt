package com.arhelicortes.catfact_dagger.presentation.viewmodel

import com.arhelicortes.catfact_dagger.domain.usecase.CatFactUseCase
import com.arhelicortes.catfact_dagger.presentation.contract.CatFactContract
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable

class CatFactPresenter(
    private val view: CatFactContract.View,
    private val catFactUseCase: CatFactUseCase,
    val subscribeOnScheduler: Scheduler,
    val observeOnScheduler: Scheduler,
): CatFactContract.Presenter {
    private val disposable = CompositeDisposable()
    override fun initData() {
        disposable.add(
            catFactUseCase.getCatFacts()
                .subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
                .subscribe(
                    { catFactData ->
                        view.showCatFactList(catFactData)
                    }
                ) { error: Throwable ->
                    view.showErrorMessage(error.message.toString())
                }
        )

    }

    override fun onDestroy() {
        disposable.clear()
    }
}
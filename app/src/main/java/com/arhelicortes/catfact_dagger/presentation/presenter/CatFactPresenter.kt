package com.arhelicortes.catfact_dagger.presentation.presenter

import com.arhelicortes.catfact_dagger.data.di.module.RxModule.SCHEDULER_IO
import com.arhelicortes.catfact_dagger.data.di.module.RxModule.SCHEDULER_MAIN_THREAD
import com.arhelicortes.catfact_dagger.domain.usecase.CatFactUseCase
import com.arhelicortes.catfact_dagger.presentation.contract.CatFactContract
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named

class CatFactPresenter @Inject constructor(
    private val view: CatFactContract.View,
    private val catFactUseCase: CatFactUseCase,
    @Named(SCHEDULER_IO)  val subscribeOnScheduler: Scheduler,
    @Named(SCHEDULER_MAIN_THREAD)  val observeOnScheduler: Scheduler,
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
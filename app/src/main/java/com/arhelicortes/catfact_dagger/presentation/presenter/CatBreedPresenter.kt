package com.arhelicortes.catfact_dagger.presentation.presenter

import com.arhelicortes.catfact_dagger.data.di.module.RxModule.SCHEDULER_IO
import com.arhelicortes.catfact_dagger.data.di.module.RxModule.SCHEDULER_MAIN_THREAD
import com.arhelicortes.catfact_dagger.domain.usecase.CatBreedListUseCase
import com.arhelicortes.catfact_dagger.presentation.contract.CatBreedContract
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named

class CatBreedPresenter @Inject constructor(
    private val view : CatBreedContract.View,
    private val catBreedsUseCase: CatBreedListUseCase,
    @Named(SCHEDULER_IO) val subscribeOnScheduler: Scheduler,
    @Named(SCHEDULER_MAIN_THREAD) val observeOnScheduler: Scheduler,
): CatBreedContract.Presenter {
    private val disposable = CompositeDisposable()

    override fun onViewCreated() {
        executeCatBreedsResponse()
    }

    private fun executeCatBreedsResponse() {
        disposable.add(
            catBreedsUseCase.getCatBreeds()
                .subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
                .subscribe(
                    { catBreedData ->
                        view.onCatBreedListReceived(catBreedData)
                    }
                ) { error: Throwable ->
                    view.showErrorMessage(error.message.toString())
                }
        )
    }

    override fun onDestroyView() {
        disposable.clear()
    }

}
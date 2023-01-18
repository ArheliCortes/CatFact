package com.arhelicortes.catfact_dagger.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arhelicortes.catfact_dagger.di.RxJavaModule.SCHEDULER_IO
import com.arhelicortes.catfact_dagger.di.RxJavaModule.SCHEDULER_MAIN_THREAD
import com.arhelicortes.catfact_dagger.domain.model.CatResult
import com.arhelicortes.catfact_dagger.domain.model.bread.CatBreedDataDto
import com.arhelicortes.catfact_dagger.domain.usecase.CatBreedListUseCase
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named

class CatBreedViewModel @Inject constructor(
    private val catBreedsUseCase: CatBreedListUseCase,
    @Named(SCHEDULER_IO) val subscribeOnScheduler: Scheduler,
    @Named(SCHEDULER_MAIN_THREAD) val observeOnScheduler: Scheduler,
): ViewModel() {
    private val disposable = CompositeDisposable()
    private var _result = MutableLiveData<CatResult<List<CatBreedDataDto>>>()
    val result: LiveData<CatResult<List<CatBreedDataDto>>> = _result

    fun onViewCreated() {
        executeCatBreedsResponse()
    }

    private fun executeCatBreedsResponse() {
        disposable.add(
            catBreedsUseCase.getCatBreeds()
                .subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
                .subscribe(
                    { catBreedData ->
                        _result.value = CatResult.Success(catBreedData)
                    }
                ) { error: Throwable ->
                    _result.value = CatResult.Error(error.message.toString())
                }
        )
    }

    fun onDestroyView() {
        disposable.clear()
    }

}
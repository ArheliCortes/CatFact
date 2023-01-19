package com.arhelicortes.catfact_dagger.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arhelicortes.catfact_dagger.di.RxJavaModule.SCHEDULER_IO
import com.arhelicortes.catfact_dagger.di.RxJavaModule.SCHEDULER_MAIN_THREAD
import com.arhelicortes.catfact_dagger.domain.model.CatResult
import com.arhelicortes.catfact_dagger.domain.model.fact.CatFactDataDto
import com.arhelicortes.catfact_dagger.domain.usecase.CatFactUseCase
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject
import javax.inject.Named

class CatFactViewModel @Inject constructor(
    private val catFactUseCase: CatFactUseCase,
    @Named(SCHEDULER_IO) val subscribeOnScheduler: Scheduler,
    @Named(SCHEDULER_MAIN_THREAD)val observeOnScheduler: Scheduler,
): ViewModel() {
    private val disposable = CompositeDisposable()
    private var _resultState = MutableLiveData<CatResult<List<CatFactDataDto>>>()
    val resultState: LiveData<CatResult<List<CatFactDataDto>>> = _resultState
    fun initData() {
        disposable.add(
            catFactUseCase.getCatFacts()
                .subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
                .subscribe(
                    { catFactData ->
                        _resultState.value = CatResult.Success(catFactData)
                    }
                ) { error: Throwable ->
                    _resultState.value = CatResult.Error(error.message.toString())
                }
        )

    }

    fun onDestroy() {
        disposable.clear()
    }
}
package com.arhelicortes.catfact_dagger.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.arhelicortes.catfact_dagger.databinding.FragmentFactListBinding
import com.arhelicortes.catfact_dagger.domain.model.fact.CatFactDataDto
import com.arhelicortes.catfact_dagger.presentation.contract.CatFactContract
import com.arhelicortes.catfact_dagger.presentation.view.adapter.CatFactCustomAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FactListFragment: Fragment(), CatFactContract.View {
    private lateinit var binding: FragmentFactListBinding


    @Inject
    lateinit var presenter: CatFactContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  FragmentFactListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.initData()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showErrorMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun showCatFactList(catFacts: List<CatFactDataDto>) {
        with(binding.catFactsRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = CatFactCustomAdapter(catFacts){}
        }
    }

}
package com.arhelicortes.catfact_dagger.presentation.view.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.arhelicortes.catfact_dagger.MainActivity
import com.arhelicortes.catfact_dagger.databinding.FragmentFactListBinding
import com.arhelicortes.catfact_dagger.domain.model.CatResult
import com.arhelicortes.catfact_dagger.domain.model.fact.CatFactDataDto
import com.arhelicortes.catfact_dagger.presentation.view.adapter.CatFactCustomAdapter
import com.arhelicortes.catfact_dagger.presentation.viewmodel.CatFactViewModel
import javax.inject.Inject

class FactListFragment : Fragment() {
    private lateinit var binding: FragmentFactListBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: CatFactViewModel

    override fun onAttach(context: Context) {
        (requireActivity() as MainActivity).appComponent.inject(this)
        super.onAttach(context)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFactListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[CatFactViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initData()
        observeDataResult()
    }

    private fun observeDataResult() {
        viewModel.resultState.observe(viewLifecycleOwner) { data ->
            when (data) {
                is CatResult.Success -> {
                    showCatFactList(data.data)
                }
                is CatResult.Error -> {
                    showErrorMessage(data.exception)
                }
            }
        }
    }

    private fun showCatFactList(catFacts: List<CatFactDataDto>) {
        with(binding.catFactsRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = CatFactCustomAdapter(catFacts) {}
        }
    }

    override fun onDestroy() {
        viewModel.onDestroy()
        super.onDestroy()
    }

    private fun showErrorMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

}
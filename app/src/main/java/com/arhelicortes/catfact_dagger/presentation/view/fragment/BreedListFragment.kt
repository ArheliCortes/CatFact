package com.arhelicortes.catfact_dagger.presentation.view.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arhelicortes.catfact_dagger.MainActivity
import com.arhelicortes.catfact_dagger.databinding.FragmentBreadListBinding
import com.arhelicortes.catfact_dagger.domain.model.CatResult
import com.arhelicortes.catfact_dagger.domain.model.bread.CatBreedDataDto
import com.arhelicortes.catfact_dagger.presentation.view.adapter.CatBreedsCustomAdapter
import com.arhelicortes.catfact_dagger.presentation.viewmodel.CatBreedViewModel
import javax.inject.Inject

class BreedListFragment : Fragment() {
    private lateinit var binding: FragmentBreadListBinding

    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory

    private lateinit var viewModel: CatBreedViewModel

    override fun onAttach(context: Context) {
        (requireActivity() as MainActivity).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[CatBreedViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  FragmentBreadListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onViewCreated()
        observeCatResult()
    }

    override fun onDestroy() {
        viewModel.onDestroyView()
        super.onDestroy()
    }

    private fun observeCatResult() {
        viewModel.result.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is CatResult.Success -> {
                    onCatBreedListReceived(result.data)
                }
                is CatResult.Error -> {
                    showErrorMessage(result.exception)
                }
            }

        })
    }

    private fun onCatBreedListReceived(catBreeds: List<CatBreedDataDto>) {
        with(binding.catBreedsRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = CatBreedsCustomAdapter(catBreeds){
                findNavController().navigate(
                    BreedListFragmentDirections
                        .actionBreadListFragmentToBreadDescriptionFragment(it)
                )
            }
        }
    }

    private fun showErrorMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
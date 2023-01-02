package com.arhelicortes.catfact_dagger.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.arhelicortes.catfact_dagger.databinding.FragmentBreadListBinding
import com.arhelicortes.catfact_dagger.domain.model.bread.CatBreedDataDto
import com.arhelicortes.catfact_dagger.presentation.contract.CatBreedContract
import com.arhelicortes.catfact_dagger.presentation.view.adapter.CatBreedsCustomAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BreedListFragment : Fragment(), CatBreedContract.View {
    private lateinit var binding: FragmentBreadListBinding

    @Inject
    lateinit var presenter: CatBreedContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  FragmentBreadListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        presenter.onDestroyView()
        super.onDestroy()
    }

    override fun onCatBreedListReceived(catBreeds: List<CatBreedDataDto>) {
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

    override fun showErrorMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
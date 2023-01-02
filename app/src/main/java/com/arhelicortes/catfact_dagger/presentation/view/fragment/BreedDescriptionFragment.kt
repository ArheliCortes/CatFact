package com.arhelicortes.catfact_dagger.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arhelicortes.catfact_dagger.databinding.FragmentBreadDescriptionBinding
import com.arhelicortes.catfact_dagger.domain.model.bread.CatBreedDataDto

class BreedDescriptionFragment : Fragment() {
    private lateinit var binding: FragmentBreadDescriptionBinding
    private var catBreedDataArgs: CatBreedDataDto? = CatBreedDataDto()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        catBreedDataArgs = arguments?.let {
            BreedDescriptionFragmentArgs.fromBundle(it).catBreedDescription
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  FragmentBreadDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpCatBreedData(catBreedDataArgs)
    }

    private fun setUpCatBreedData(catBreedDataDto: CatBreedDataDto?) {
        with(binding) {
            catBreedDataDto?.apply {
               catBreedDescTitleTextView.text = breed
               catBreedDescCountryTextView.text = country
               catBreedDescOriginTextView.text = origin
               catBreedDescCoatTextView.text = coat
               catBreedDescPatternTextView.text = pattern
            }
        }
    }
}
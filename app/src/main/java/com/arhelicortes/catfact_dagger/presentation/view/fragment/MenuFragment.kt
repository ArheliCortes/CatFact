package com.arhelicortes.catfact_dagger.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.arhelicortes.catfact_dagger.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleButtonActions()
    }

    private fun handleButtonActions() {
        with(MenuFragmentDirections) {
            binding.catMenuFactButton.setOnClickListener{
                findNavController().navigate(
                    actionMenuFragmentToFactListFragment()
                )
            }
            binding.catBreedButton.setOnClickListener{
                findNavController().navigate(
                    actionMenuFragmentToBreadListFragment()
                )
            }
        }
    }
}
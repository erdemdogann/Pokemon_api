package com.example.pokemon_api

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.pokemon_api.databinding.FragmentDeatilPageBinding
import kotlinx.coroutines.launch


class DeatilPage : Fragment() {

    private var _binding: FragmentDeatilPageBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<com.example.pokemon_api.DeatilPageArgs>()

    private val viewModel by viewModels<DetailPageViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDeatilPageBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadData(args.pokename)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.stateFlow.flowWithLifecycle(viewLifecycleOwner.lifecycle).collect {
                binding.pokemonWeight.text = it.weight.toString()
                binding.pokemonHeight.text = it.height.toString()
                Glide.with(requireActivity()).load(it.url).into(binding.pokemonImageView)
            }
        }
    }


}
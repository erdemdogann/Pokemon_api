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
import com.example.pokemon_api.databinding.FragmentDetailPageBinding
import kotlinx.coroutines.launch


class DetailPageFragment : Fragment() {

    private var _binding: FragmentDetailPageBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<DetailPageFragmentArgs>()

    private val viewModel by viewModels<DetailPageViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailPageBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadData(args.pokename)
        observeData()
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.stateFlow.flowWithLifecycle(viewLifecycleOwner.lifecycle).collect {
                binding.pokemonWeight.text = it.weight.toString()
                binding.pokemonHeight.text = it.height.toString()
                Glide.with(requireActivity()).load(it.url).into(binding.pokemonImageView)
            }
        }
    }
}
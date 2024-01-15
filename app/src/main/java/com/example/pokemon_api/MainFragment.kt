package com.example.pokemon_api

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pokemon_api.adapter.RecyclerViewAdapter
import com.example.pokemon_api.baseModels.PokeModel
import com.example.pokemon_api.databinding.FragmentMainBinding
import com.example.pokemon_api.`interface`.PokemonApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainFragment : Fragment() {

    private var recyclerViewAdapter: RecyclerViewAdapter? = null
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

    private fun loadData() {
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(PokemonApi::class.java).getdata(0, 1302)
            .enqueue(object : Callback<PokeModel> {
                override fun onResponse(
                    call: Call<PokeModel>,
                    response: Response<PokeModel>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        response.body().let { pokeModel ->
                            recyclerViewAdapter = RecyclerViewAdapter(pokeModel?.results.orEmpty()) {
                                findNavController().navigate(
                                    MainFragmentDirections.actionMainFragmentToDeatilPage(it)
                                )
                            }.also {
                                binding.recyclerView.adapter = it
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<PokeModel>, t: Throwable) {
                    t.printStackTrace()
                }
            })
    }

}
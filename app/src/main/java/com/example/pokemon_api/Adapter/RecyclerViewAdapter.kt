package com.example.pokemon_api.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon_api.baseModels.PokemonModel
import com.example.pokemon_api.databinding.RowBinding

class RecyclerViewAdapter(
    private val pokemonList: List<PokemonModel>,
    private val onClick: (url: String) -> Unit
) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    inner class RowHolder(private val itemBinding: RowBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(pokemonModel: PokemonModel) {

            itemBinding.root.setOnClickListener {
                onClick(pokemonModel.name.orEmpty())
                //onClick.invoke(pokemonmodel.url.orEmpty())   Tunanın tercihi
            }

            itemBinding.pokemonName.text = pokemonModel.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val itemBinding = RowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RowHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(pokemonList[position])
    }
}
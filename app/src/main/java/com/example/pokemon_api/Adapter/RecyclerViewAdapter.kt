package com.example.pokemon_api.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon_api.BaseModels.Pokemonmodel
import com.example.pokemon_api.databinding.RowBinding


class RecyclerViewAdapter(
    private val pokemonList: List<Pokemonmodel>,
    private val onClick: (url: String) -> Unit,

) :
    RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    inner class RowHolder(private val itemBinding: RowBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(pokemonmodel: Pokemonmodel) {

            itemBinding.root.setOnClickListener {
                onClick(pokemonmodel.name.orEmpty())
                //onClick.invoke(pokemonmodel.url.orEmpty())   Tunanın tercihi
            }

            itemBinding.pokemonName.text = pokemonmodel.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val itemBinding = RowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RowHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        val pokemonmodel: Pokemonmodel = pokemonList[position]

        holder.bind(pokemonmodel)
    }
}
package com.example.pokemon_api.baseModels

data class PokeModel(
    val count: Int?,
    val next: String?,
    val previous: Any?,
    val results: List<PokemonModel>?
)
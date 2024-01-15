package com.example.pokemon_api

import com.example.pokemon_api.Interface.pokedetail
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val client: pokedetail by lazy {
        Retrofit.Builder().
        baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(pokedetail::class.java)
    }
}
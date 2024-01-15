package com.example.pokemon_api

import com.example.pokemon_api.`interface`.PokeDetailApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val API_URL = "https://pokeapi.co/api/v2/"

    val client: PokeDetailApi by lazy {
        Retrofit.Builder().
        baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeDetailApi::class.java)
    }
}
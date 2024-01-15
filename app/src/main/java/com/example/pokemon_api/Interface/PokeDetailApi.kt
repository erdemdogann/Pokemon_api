package com.example.pokemon_api.`interface`


import com.example.pokemon_api.model.Sprites2
import com.example.pokemon_api.model.PokeModels2
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeDetailApi {
    @GET("pokemon/{name}")
    fun getData(
        @Path("name") name: String
    ): Call<PokeModels2>

    @GET("pokemon/{name}")
    fun takeData(
        @Path("name") name: String
    ): Call<Sprites2>
}
package com.example.pokemon_api.`interface`

import com.example.pokemon_api.baseModels.PokeModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    fun getdata(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Call<PokeModel>

//    @GET("pokemon?offset=0&limit=1302")
//    fun getdata(): Call<PokeModel>

}
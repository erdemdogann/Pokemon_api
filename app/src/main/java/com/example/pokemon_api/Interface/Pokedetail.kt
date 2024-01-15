package com.example.pokemon_api.Interface


import com.example.pokemon_api.Model.DreamWorld
import com.example.pokemon_api.Model.Sprites2
import com.example.pokemon_api.Model.poekmodels2
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface pokedetail {
    @GET ("pokemon/{name}")
    fun getdata(
        @Path("name")name: String
    ): Call<poekmodels2>

    @GET ("pokemon/{name}")
    fun takedata(
        @Path("name")name: String
    ) : Call<Sprites2>
}
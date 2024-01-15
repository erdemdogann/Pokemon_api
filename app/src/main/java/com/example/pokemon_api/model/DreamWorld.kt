package com.example.pokemon_api.model

import com.google.gson.annotations.SerializedName

data class DreamWorld(
    @SerializedName("front_default")
    val front_default: String?,
    val front_female: Any?
)
data class Sprites2(
    @SerializedName("sprites")
    val dreamWorld: DreamWorld?
)
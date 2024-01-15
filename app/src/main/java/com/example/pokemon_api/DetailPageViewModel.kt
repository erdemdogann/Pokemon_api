package com.example.pokemon_api

import androidx.lifecycle.ViewModel
import com.example.pokemon_api.model.PokeModels2
import com.example.pokemon_api.model.Sprites2
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailPageViewModel : ViewModel() {

    private val _stateFlow = MutableStateFlow(DetailPageUiScreen())
    val stateFlow = _stateFlow.asStateFlow()

    fun loadData(pokeName: String) {
        RetrofitClient.client.getData(pokeName)
            .enqueue(object : Callback<PokeModels2> {
                override fun onResponse(call: Call<PokeModels2>, response: Response<PokeModels2>) {
                    _stateFlow.update {
                        with(response.body()) {
                            it.copy(weight = this?.weight, height = this?.height)
                        }
                    }
                }

                override fun onFailure(call: Call<PokeModels2>, t: Throwable) = Unit

            })

        RetrofitClient.client.takeData(pokeName)
            .enqueue(object : Callback<Sprites2> {
                override fun onResponse(call: Call<Sprites2>, response: Response<Sprites2>) {
                    _stateFlow.update {
                        it.copy(url = response.body()?.dreamWorld?.front_default.orEmpty())
                    }
                }

                override fun onFailure(call: Call<Sprites2>, t: Throwable) = Unit
            })
    }
}

data class DetailPageUiScreen(
    val weight: Int? = 0,
    val height: Int? = 0,
    val url: String = ""
)
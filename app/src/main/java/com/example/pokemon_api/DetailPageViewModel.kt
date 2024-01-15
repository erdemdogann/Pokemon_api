package com.example.pokemon_api

import androidx.lifecycle.ViewModel
import com.example.pokemon_api.Model.Sprites2
import com.example.pokemon_api.Model.poekmodels2
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
        RetrofitClient.client.getdata(pokeName)
            .enqueue(object : Callback<poekmodels2> {
                override fun onResponse(call: Call<poekmodels2>, response: Response<poekmodels2>) {
                    _stateFlow.update {
                        with(response.body()) {
                            it.copy(weight = this?.weight , height = this?.height )
                        }
                    }
                }

                override fun onFailure(call: Call<poekmodels2>, t: Throwable) {

                }

            })
        RetrofitClient.client.takedata(pokeName)
            .enqueue(object : Callback<Sprites2> {
                override fun onResponse(call: Call<Sprites2>, response: Response<Sprites2>) {
                    _stateFlow.update {
                        it.copy(url = response.body()?.dreamWorld?.front_default.orEmpty())
                    }
                }

                override fun onFailure(call: Call<Sprites2>, t: Throwable) {

                }


            })
    }
}

data class DetailPageUiScreen(
    val weight: Int? = 0,
    val height: Int? = 0,
    val url: String = ""
)
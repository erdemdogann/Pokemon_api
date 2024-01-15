package com.example.pokemon_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokemon_api.Adapter.RecyclerViewAdapter
import com.example.pokemon_api.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var recyclerViewAdapter: RecyclerViewAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }


}
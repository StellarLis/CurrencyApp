package com.example.currencyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.currencyapp.databinding.ActivityMainBinding
import com.example.currencyapp.presentation.ConverterFragment
import com.example.currencyapp.presentation.CurrencyFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //
        val navController = Navigation.findNavController(this, R.id.navHost)
        binding.bNav.setupWithNavController(navController)
    }
}
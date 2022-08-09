package com.example.currencyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, CurrencyFragment())
            .addToBackStack(null)
            .commit()
        //
        binding.bNav.setOnNavigationItemSelectedListener {
            val fm = supportFragmentManager.beginTransaction()
            when (it.itemId) {
                R.id.currencyIcon -> {
                    fm.replace(R.id.frame, CurrencyFragment())
                    binding.tvTitle.text = "Exchange rates"
                }
                R.id.converterIcon -> {
                    fm.replace(R.id.frame, ConverterFragment())
                    binding.tvTitle.text = "Converter"
                }
            }
            fm.addToBackStack(null)
            fm.commit()
            true
        }
    }
}
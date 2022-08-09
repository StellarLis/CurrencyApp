package com.example.currencyapp.presentation

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.example.currencyapp.R
import com.example.currencyapp.databinding.FragmentConverterBinding
import com.example.currencyapp.viewmodels.ConverterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConverterFragment : Fragment() {
    private lateinit var binding: FragmentConverterBinding
    private val vm: ConverterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConverterBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //
        vm.rubToUsdData.observe(viewLifecycleOwner) {
            binding.edRubUsd.setText(it.toString())
        }
        vm.usdData.observe(viewLifecycleOwner) {
            binding.edUsdRub.setText(it.toString())
        }
        vm.rubToEurData.observe(viewLifecycleOwner) {
            binding.edRubEur.setText(it.toString())
        }
        vm.eurData.observe(viewLifecycleOwner) {
            binding.edEurRub.setText(it.toString())
        }
        // USD listeners
        var isRubChangedLatestUSD: Boolean = true
        binding.edRubUsd.addTextChangedListener {
            isRubChangedLatestUSD = true
        }
        binding.edUsdRub.addTextChangedListener {
            isRubChangedLatestUSD = false
        }
        binding.changeUsdBtn.setOnClickListener {
            if (!binding.edUsdRub.text.isEmpty() && !isRubChangedLatestUSD) {
                vm.setRubToUsdData(binding.edUsdRub.text.toString().toDouble())
            } else if (!binding.edRubUsd.text.isEmpty() && isRubChangedLatestUSD){
                vm.setUsdData(binding.edRubUsd.text.toString().toDouble())
            }
        }
        // EUR listeners
        var isRubChangedLatestEUR: Boolean = true
        binding.edRubEur.addTextChangedListener {
            isRubChangedLatestEUR = true
        }
        binding.edEurRub.addTextChangedListener {
            isRubChangedLatestEUR = false
        }
        binding.changeEurBtn.setOnClickListener {
            if (!binding.edEurRub.text.isEmpty() && !isRubChangedLatestEUR) {
                vm.setRubToEurData(binding.edEurRub.text.toString().toDouble())
            } else if (!binding.edRubEur.text.isEmpty() && isRubChangedLatestEUR) {
                vm.setEurData(binding.edRubEur.text.toString().toDouble())
            }
        }
    }
}
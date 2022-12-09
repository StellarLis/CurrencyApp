package com.example.currencyapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.currencyapp.R
import com.example.currencyapp.adapters.CurrencyAdapter
import com.example.currencyapp.databinding.FragmentCurrencyBinding
import com.example.currencyapp.viewmodels.CurrencyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyFragment : Fragment() {
    private lateinit var binding: FragmentCurrencyBinding
    private val adapter = CurrencyAdapter()
    private val vm: CurrencyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrencyBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rcView.adapter = adapter
        vm.listForRV.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        vm.errorMessage.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
        }
        vm.setList()
    }
}
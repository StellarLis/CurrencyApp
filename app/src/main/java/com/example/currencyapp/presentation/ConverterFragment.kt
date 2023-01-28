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
import com.example.currencyapp.adapters.ConverterAdapter
import com.example.currencyapp.databinding.FragmentConverterBinding
import com.example.currencyapp.viewmodels.ConverterViewModel
import com.example.domain.domain.models.ConverterModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConverterFragment : Fragment() {
    private lateinit var binding: FragmentConverterBinding
    private val vm: ConverterViewModel by viewModels()
    private lateinit var adapter: ConverterAdapter
    private val listOfItems = listOf(
        ConverterModel("USD", R.drawable.us, 1),
        ConverterModel("EUR", R.drawable.european, 2),
        ConverterModel("GBP", R.drawable.united_kingdom, 3),
        ConverterModel("CNY", R.drawable.china, 4),
        ConverterModel("JPY", R.drawable.japan, 5),
        ConverterModel("INR", R.drawable.india, 6),
        ConverterModel("TRY", R.drawable.turkey, 7),
        ConverterModel("CHF", R.drawable.switzerland, 8),
        ConverterModel("ILS", R.drawable.israel, 9),
    )

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
        adapter = ConverterAdapter(vm, viewLifecycleOwner)
        binding.rcView.adapter = adapter
        adapter.submitList(listOfItems)
    }
}
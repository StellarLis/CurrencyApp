package com.example.currencyapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyapp.R
import com.example.currencyapp.databinding.ItemCurrencyBinding
import com.example.domain.domain.models.CurrencyRVModel

class CurrencyAdapter : ListAdapter<CurrencyRVModel, CurrencyAdapter.Holder>(Comparator()) {

    class Holder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = ItemCurrencyBinding.bind(item)
        fun bind(model: CurrencyRVModel) {
            binding.name.text = model.name
            binding.date.text = model.date
            binding.currency.text = model.currency
            binding.image.setImageResource(model.imageSource)
        }
    }
    class Comparator : DiffUtil.ItemCallback<CurrencyRVModel>() {
        override fun areItemsTheSame(oldItem: CurrencyRVModel, newItem: CurrencyRVModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CurrencyRVModel, newItem: CurrencyRVModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }
}
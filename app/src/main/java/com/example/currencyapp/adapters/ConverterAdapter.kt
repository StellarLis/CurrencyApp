package com.example.currencyapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyapp.R
import com.example.currencyapp.databinding.ItemConverterBinding
import com.example.currencyapp.viewmodels.ConverterViewModel
import com.example.domain.domain.models.ConverterModel
import hilt_aggregated_deps._dagger_hilt_android_internal_lifecycle_DefaultViewModelFactories_FragmentEntryPoint

class ConverterAdapter(
    private val vm: ConverterViewModel,
    private val lifecycleOwner: LifecycleOwner
) : ListAdapter<ConverterModel, ConverterAdapter.Holder>(Comparator()) {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemConverterBinding.bind(view)
        fun bind(item: ConverterModel, vm: ConverterViewModel, lifecycleOwner: LifecycleOwner) {
            binding.currencyImage.setImageResource(item.imageId)
            binding.currencyName.text = item.name
            var isRubChanged = true
            binding.edRub.addTextChangedListener {
                isRubChanged = true
            }
            binding.edVal.addTextChangedListener {
                isRubChanged = false
            }
            when (item.id) {
                1 -> {
                    vm.rubToUsdData.observe(lifecycleOwner) {
                        binding.edVal.setText(it.toString())
                    }
                    vm.usdData.observe(lifecycleOwner) {
                        binding.edRub.setText(it.toString())
                    }
                }
                2 -> {
                    vm.rubToEurData.observe(lifecycleOwner) {
                        binding.edVal.setText(it.toString())
                    }
                    vm.eurData.observe(lifecycleOwner) {
                        binding.edRub.setText(it.toString())
                    }
                }
                3 -> {
                    vm.rubToGbpData.observe(lifecycleOwner) {
                        binding.edVal.setText(it.toString())
                    }
                    vm.gbpData.observe(lifecycleOwner) {
                        binding.edRub.setText(it.toString())
                    }
                }
                4 -> {
                    vm.rubToCnyData.observe(lifecycleOwner) {
                        binding.edVal.setText(it.toString())
                    }
                    vm.cnyData.observe(lifecycleOwner) {
                        binding.edRub.setText(it.toString())
                    }
                }
                5 -> {
                    vm.rubToJpyData.observe(lifecycleOwner) {
                        binding.edVal.setText(it.toString())
                    }
                    vm.jpyData.observe(lifecycleOwner) {
                        binding.edRub.setText(it.toString())
                    }
                }
                6 -> {
                    vm.rubToInrData.observe(lifecycleOwner) {
                        binding.edVal.setText(it.toString())
                    }
                    vm.inrData.observe(lifecycleOwner) {
                        binding.edRub.setText(it.toString())
                    }
                }
                7 -> {
                    vm.rubToTryData.observe(lifecycleOwner) {
                        binding.edVal.setText(it.toString())
                    }
                    vm.tryData.observe(lifecycleOwner) {
                        binding.edRub.setText(it.toString())
                    }
                }
                8 -> {
                    vm.rubToChfData.observe(lifecycleOwner) {
                        binding.edVal.setText(it.toString())
                    }
                    vm.chfData.observe(lifecycleOwner) {
                        binding.edRub.setText(it.toString())
                    }
                }
                9 -> {
                    vm.rubToIlsData.observe(lifecycleOwner) {
                        binding.edVal.setText(it.toString())
                    }
                    vm.ilsData.observe(lifecycleOwner) {
                        binding.edRub.setText(it.toString())
                    }
                }
            }
            binding.changeBtn.setOnClickListener {
                when (item.id) {
                    1 -> {
                        if (!binding.edRub.text.isEmpty() && isRubChanged) {
                            vm.setRubToUsdData(binding.edRub.text.toString().toDouble())
                        } else if (!binding.edVal.text.isEmpty() && !isRubChanged){
                            vm.setUsdData(binding.edVal.text.toString().toDouble())
                        }
                    }
                    2 -> {
                        if (!binding.edRub.text.isEmpty() && isRubChanged) {
                            vm.setRubToEurData(binding.edRub.text.toString().toDouble())
                        } else if (!binding.edVal.text.isEmpty() && !isRubChanged){
                            vm.setEurData(binding.edVal.text.toString().toDouble())
                        }
                    }
                    3 -> {
                        if (!binding.edRub.text.isEmpty() && isRubChanged) {
                            vm.setRubToGbpData(binding.edRub.text.toString().toDouble())
                        } else if (!binding.edVal.text.isEmpty() && !isRubChanged){
                            vm.setGbpData(binding.edVal.text.toString().toDouble())
                        }
                    }
                    4 -> {
                        if (!binding.edRub.text.isEmpty() && isRubChanged) {
                            vm.setRubToCnyData(binding.edRub.text.toString().toDouble())
                        } else if (!binding.edVal.text.isEmpty() && !isRubChanged){
                            vm.setCnyData(binding.edVal.text.toString().toDouble())
                        }
                    }
                    5 -> {
                        if (!binding.edRub.text.isEmpty() && isRubChanged) {
                            vm.setRubToJpyData(binding.edRub.text.toString().toDouble())
                        } else if (!binding.edVal.text.isEmpty() && !isRubChanged){
                            vm.setJpyData(binding.edVal.text.toString().toDouble())
                        }
                    }
                    6 -> {
                        if (!binding.edRub.text.isEmpty() && isRubChanged) {
                            vm.setRubToInrData(binding.edRub.text.toString().toDouble())
                        } else if (!binding.edVal.text.isEmpty() && !isRubChanged){
                            vm.setInrData(binding.edVal.text.toString().toDouble())
                        }
                    }
                    7 -> {
                        if (!binding.edRub.text.isEmpty() && isRubChanged) {
                            vm.setRubToTryData(binding.edRub.text.toString().toDouble())
                        } else if (!binding.edVal.text.isEmpty() && !isRubChanged){
                            vm.setTryData(binding.edVal.text.toString().toDouble())
                        }
                    }
                    8 -> {
                        if (!binding.edRub.text.isEmpty() && isRubChanged) {
                            vm.setRubToChfData(binding.edRub.text.toString().toDouble())
                        } else if (!binding.edVal.text.isEmpty() && !isRubChanged){
                            vm.setChfData(binding.edVal.text.toString().toDouble())
                        }
                    }
                    9 -> {
                        if (!binding.edRub.text.isEmpty() && isRubChanged) {
                            vm.setRubToIlsData(binding.edRub.text.toString().toDouble())
                        } else if (!binding.edVal.text.isEmpty() && !isRubChanged){
                            vm.setIlsData(binding.edVal.text.toString().toDouble())
                        }
                    }
                }
            }
            binding.deleteBtn1.setOnClickListener {
                binding.edRub.setText("0")
            }
            binding.deleteBtn2.setOnClickListener {
                binding.edVal.setText("0")
            }
        }
    }
    class Comparator : DiffUtil.ItemCallback<ConverterModel>() {
        override fun areItemsTheSame(oldItem: ConverterModel, newItem: ConverterModel): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: ConverterModel, newItem: ConverterModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_converter, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position), vm, lifecycleOwner)
    }
}
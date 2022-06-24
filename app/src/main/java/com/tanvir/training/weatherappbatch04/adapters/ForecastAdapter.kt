package com.tanvir.training.weatherappbatch04.adapters

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tanvir.training.weatherappbatch04.databinding.ForecastItemRowBinding
import com.tanvir.training.weatherappbatch04.models.ForecastModel

class ForecastAdapter : ListAdapter<ForecastModel.ForecastItem, ForecastAdapter.ForecastViewholder>(ForecastDiffUtil()){

    class ForecastViewholder(val binding: ForecastItemRowBinding) :
            RecyclerView.ViewHolder(binding.root) {
                fun bind(item: ForecastModel.ForecastItem) {
                    binding.item = item
                }
            }

    class ForecastDiffUtil : DiffUtil.ItemCallback<ForecastModel.ForecastItem>() {
        override fun areItemsTheSame(
            oldItem: ForecastModel.ForecastItem,
            newItem: ForecastModel.ForecastItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ForecastModel.ForecastItem,
            newItem: ForecastModel.ForecastItem
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewholder {
        val binding = ForecastItemRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ForecastViewholder(binding)
    }

    override fun onBindViewHolder(holder: ForecastViewholder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}
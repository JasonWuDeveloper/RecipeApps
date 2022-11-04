package com.example.reservoirapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.reservoirapps.databinding.ReservoirLayoutAdapterBinding
import com.example.reservoirapps.models.ReservoirInfo
import com.example.reservoirapps.models.ResponseData

class ReservoirAdapter: RecyclerView.Adapter<ReservoirAdapter.ReservoirViewHolder>() {

    inner class ReservoirViewHolder(val binding: ReservoirLayoutAdapterBinding):
        RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object :DiffUtil.ItemCallback<ResponseData>() {
        override fun areItemsTheSame(oldItem: ResponseData, newItem: ResponseData): Boolean {
            return oldItem.ReservoirName == newItem.ReservoirName
        }

        override fun areContentsTheSame(oldItem: ResponseData, newItem: ResponseData): Boolean {
            return oldItem == newItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var reservoir: List<ResponseData>
            get() = differ.currentList
    set(value) {
        differ.submitList(value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservoirViewHolder {
        return ReservoirViewHolder(ReservoirLayoutAdapterBinding.inflate(
            LayoutInflater.from(parent.context),parent, false
        ))
    }

    override fun onBindViewHolder(holder: ReservoirViewHolder, position: Int) {
        val currReservoir = reservoir[position]
        holder.binding.apply {
            tvReservoirName.text = currReservoir.ReservoirName
            tvCrossFlow.text = currReservoir.CrossFlow

        }
    }

    override fun getItemCount() = reservoir.size
}
package com.tw.chuxing.transportation.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tw.chuxing.R
import com.tw.chuxing.databinding.ProposalsItemBinding
import com.tw.chuxing.transportation.model.TransportationProposal

class ProposalsAdapter(private val proposals: List<TransportationProposal>) :
    RecyclerView.Adapter<ProposalsAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = ProposalsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.carType.text = context.getString(R.string.car_type, proposals[position].carType)
        holder.binding.duration.text = context.getString(R.string.duration, proposals[position].duration)
        holder.binding.price.text = context.getString(R.string.price, proposals[position].price)
    }

    override fun getItemCount() = proposals.size

    class ViewHolder(val binding: ProposalsItemBinding) : RecyclerView.ViewHolder(binding.root)
}
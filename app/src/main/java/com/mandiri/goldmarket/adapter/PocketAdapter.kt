package com.mandiri.goldmarket.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.goldmarket.data.model.Pocket
import com.mandiri.goldmarket.databinding.ListPocketBinding

class PocketAdapter(private var pocket: List<Pocket> = mutableListOf(), private val onClickListener: OnClickListener):
    RecyclerView.Adapter<PocketAdapter.PocketViewHolder>() {

    class PocketViewHolder(val binding: ListPocketBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PocketViewHolder {
        val binding = ListPocketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PocketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PocketViewHolder, position: Int) {
        with(holder) {
            with(pocket[position]) {
                binding.textViewPocket.text = this.pocketName
                binding.textViewQty.text = this.pocketQuantity.toString()
                binding.btnDetail.setOnClickListener {
                    onClickListener.onClickItem(position)
                }
                binding.btnDelete.setOnClickListener{
                    onClickListener.onDeleteItem(position)
                }
            }
        }
    }

    override fun getItemCount(): Int = pocket.size

    fun updateData(pocket: List<Pocket>) {
        this.pocket = pocket
        notifyDataSetChanged()
    }

    interface OnClickListener {
        fun onClickItem(position: Int)
        fun onDeleteItem(position: Int)
    }
}
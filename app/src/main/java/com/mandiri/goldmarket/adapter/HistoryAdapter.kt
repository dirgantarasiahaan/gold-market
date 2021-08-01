package com.mandiri.goldmarket.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.goldmarket.data.model.History
import com.mandiri.goldmarket.databinding.ListHistoryBinding

class HistoryAdapter(private val onClickListener: OnClickListener):
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private var history: List<History> = mutableListOf()

    class HistoryViewHolder(val binding: ListHistoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ListHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        with(holder) {
            with(history[position]) {
                binding.textViewTitle.text = this.transaction
                binding.textViewDate.text = this.date
                binding.cardItem.setOnClickListener {
                    onClickListener.onClickItem(position)
                }
            }
        }
    }

    override fun getItemCount(): Int = history.size

    fun updateData(history: List<History>) {
        this.history = history
        notifyDataSetChanged()
    }

    interface OnClickListener {
        fun onClickItem(position: Int)
    }
}
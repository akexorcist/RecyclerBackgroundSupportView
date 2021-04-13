package com.akexorcist.example.recyclerbackgroundsupportview.sample

import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.example.recyclerbackgroundsupportview.sample.databinding.ViewItemBinding

class MainViewHolder(private val binding: ViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun setText(text: String) {
        binding.textView.text = text
    }
}

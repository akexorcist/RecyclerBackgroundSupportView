package com.akexorcist.example.recyclerbackgroundsupportview.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.example.recyclerbackgroundsupportview.sample.databinding.ViewItemBinding

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder =
        MainViewHolder(ViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = 40

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.setText("Item $position")
    }
}

package com.akexorcist.example.recyclerbackgroundsupportview.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder =
            MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_item, parent, false))

    override fun getItemCount(): Int = 40

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.setText("Item $position")
    }
}

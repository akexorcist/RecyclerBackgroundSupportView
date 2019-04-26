package com.akexorcist.example.recyclerbackgroundsupportview.sample

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.view_item.*

class MainViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    fun setText(text: String) {
        textView.text = text
    }
}

package com.akexorcist.example.recyclerbackgroundsupportview.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerBackgroundSupportView.getRecyclerView().layoutManager = LinearLayoutManager(this)
        recyclerBackgroundSupportView.getRecyclerView().adapter = MainAdapter()
    }
}

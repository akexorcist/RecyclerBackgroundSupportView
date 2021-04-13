package com.akexorcist.example.recyclerbackgroundsupportview.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.akexorcist.example.recyclerbackgroundsupportview.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerBackgroundSupportView.getRecyclerView().layoutManager = LinearLayoutManager(this)
        binding.recyclerBackgroundSupportView.getRecyclerView().adapter = MainAdapter()
    }
}

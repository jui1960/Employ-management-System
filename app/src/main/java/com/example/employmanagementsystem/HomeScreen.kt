package com.example.employmanagementsystem

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employmanagementsystem.databinding.ActivityHomeScreenBinding

class HomeScreen : AppCompatActivity() {

    private lateinit var binding: ActivityHomeScreenBinding
    private lateinit var viewModel: EmployViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.addBtn.setOnClickListener {
            startActivity(Intent(this, AddScreen::class.java))
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this)[EmployViewModel::class.java]

        viewModel.liveData.observe(this) { list ->
            binding.cnt.text = "${list.size}"

            val adapter = EmployAdapter(
                list,
                onedit ={},
                ondelete = {},
                onitem = {},

                )
            binding.recyclerView.adapter = adapter
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadDataView()
    }
}
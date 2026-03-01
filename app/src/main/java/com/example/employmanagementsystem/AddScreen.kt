package com.example.employmanagementsystem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.employmanagementsystem.databinding.ActivityAddScreenBinding

class AddScreen : AppCompatActivity() {
    private lateinit var binding: ActivityAddScreenBinding
    private lateinit var viewModel: ViewModel
    private var selectedImageUri: android.net.Uri? = null

    private val imgPiker = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let {
            selectedImageUri = it
            binding.imgadd.setImageURI(it)
        }
    }


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            binding = ActivityAddScreenBinding.inflate(layoutInflater)
            setContentView(binding.root)



            viewModel = ViewModelProvider(this)[ViewModel::class.java]

            binding.imgadd.setOnClickListener {
                imgPiker.launch("image/*")
            }

            binding.btnSave.setOnClickListener {
                val img = selectedImageUri?.toString()
                val name = binding.nameEt.text.toString()
                val position = binding.positionEt.text.toString()
                val education = binding.EducationEt.text.toString()
                val salary = binding.salaryEt.text.toString().toIntOrNull() ?: 0

                val data = Data(
                    img = img,
                    name = name,
                    position = position,
                    education = education,
                    salary = salary
                )
                viewModel.insertView(data)

                Toast.makeText(
                    this@AddScreen, "data saved successfully",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }
package com.technicaltask.innovecsweatherapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.technicaltask.innovecsweatherapplication.databinding.ActivityMainBinding
import com.technicaltask.innovecsweatherapplication.utils.Utils

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
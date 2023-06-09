package com.demo.testcases

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.testcases.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val emaill = intent.getStringExtra("KEY")
        binding.txtMessage.text = emaill

    }

}
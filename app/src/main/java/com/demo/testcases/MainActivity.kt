package com.demo.testcases

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.demo.testcases.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnSignup.setOnClickListener {
            validatePassword(this,binding.edtEmail.text.toString(),binding.edtPassword.text.toString())



        }

    }

    fun validatePassword(context: Context,email:String, password: String){
        when {
            email.isEmpty() ->{
                Toast.makeText(this, "Email should not be empty", Toast.LENGTH_SHORT).show()
            }
            password.isEmpty() -> {
                Toast.makeText(this, "Password should not be empty", Toast.LENGTH_SHORT).show()
            }
            password.length<6 -> {
                Toast.makeText(this, "Password should be greater than 6", Toast.LENGTH_SHORT).show()
            }
            password.length>15 -> {
                Toast.makeText(this, "Password should be less than 15", Toast.LENGTH_SHORT).show()
            }
            else -> {
                val emaill = "Email - ${binding.edtEmail.text}"
                val intent = Intent(this,HomeActivity::class.java)
                intent.putExtra("KEY",emaill)
                startActivity(intent)
            }
        }

    }

}
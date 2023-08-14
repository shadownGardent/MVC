package com.example.mvc_by_myself.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvc_by_myself.R
import com.example.mvc_by_myself.databinding.ActivityLoginSuccessActivtyBinding

class LoginSuccessActivty : AppCompatActivity() {
    private lateinit var binding : ActivityLoginSuccessActivtyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginSuccessActivtyBinding.inflate(layoutInflater)
        setContentView(binding.root)
            val msg = getString(R.string.text_welcome) + " " +
                    intent?.getStringExtra(EXTRA_MESSAGE)
        binding.textResult.text = msg
    }

    companion object {
        const val EXTRA_MESSAGE = "com.example.mvc_by_myself"
    }
}
package com.example.mvc_by_myself.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mvc_by_myself.R
import com.example.mvc_by_myself.controller.Controller
import com.example.mvc_by_myself.controller.ILoginController
import com.example.mvc_by_myself.controller.IViewController
import com.example.mvc_by_myself.databinding.ActivityMainBinding
import com.example.mvc_by_myself.model.User
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), IViewController {
    private lateinit var binding: ActivityMainBinding
    private var controller: Controller? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showProgressBar(View.GONE)
        controller = Controller(this)

        binding.btnLogin.setOnClickListener {
            showProgressBar(View.VISIBLE)
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()
            controller?.login(email, password, object : ILoginController.LoginListener {
                override fun onResponse(user: User?) {
                    if (user != null) {
                        startActivityForLoginSuccess(user)
                    } else {
                        showProgressBar(View.GONE)
                        showLoginFailed()
                    }
                }
            })
        }
    }

    override fun showProgressBar(visibility: Int) {
        binding.progressBar.visibility = visibility
    }

    override fun showLoginFailed() {
        Snackbar.make(
            binding.root,
            getString(R.string.text_login_failed),
            Snackbar.LENGTH_LONG
        ).show()
    }

    override fun showInputError() {
        Snackbar.make(
            binding.root,
            getString(R.string.text_input_invalid),
            Snackbar.LENGTH_LONG
        ).show()
    }

    override fun startActivityForLoginSuccess(user: User) {
        val intent = Intent(this, LoginSuccessActivty::class.java)
        intent.putExtra(LoginSuccessActivty.EXTRA_MESSAGE, user.email)
        startActivity(intent)
    }
}
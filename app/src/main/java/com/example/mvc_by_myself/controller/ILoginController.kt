package com.example.mvc_by_myself.controller

import com.example.mvc_by_myself.model.User

interface ILoginController {
    interface LoginListener {
        fun onResponse(user : User?)
    }

    fun login(email: String, password: String, listener: LoginListener)

    fun checkInput(email: String, password: String): Boolean
}
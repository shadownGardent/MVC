package com.example.mvc_by_myself.controller

import com.example.mvc_by_myself.model.User

interface IViewController {
    fun showProgressBar(visibility: Int)
    fun showLoginFailed()
    fun showInputError()
    fun startActivityForLoginSuccess(user: User)
}
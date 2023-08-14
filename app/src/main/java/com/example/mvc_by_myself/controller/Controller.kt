package com.example.mvc_by_myself.controller

import android.view.View
import com.example.mvc_by_myself.model.User
import com.example.mvc_by_myself.model.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Controller(private val view: IViewController) : ILoginController {

    override fun login(
        email: String,
        password: String,
        listener: ILoginController.LoginListener
    ) {
        if (checkInput(email, password)) {
            val scope = CoroutineScope(Job() + Dispatchers.Main)
            scope.launch {
                delay(2000L)
                val users = Utils.fakeDate()
                var loginUser: User? = null
                for (user in users) {
                    if (user.email.compareTo(email) == 0 &&
                        user.password.compareTo(password) == 0
                    ) {
                        loginUser = user
                        break
                    }
                }
                listener.onResponse(loginUser)
            }
        }else {
            view.showProgressBar(View.GONE)
            view.showInputError()
        }
    }

    override fun checkInput(email: String, password: String): Boolean {
        return !(email.isEmpty() || password.isEmpty())
    }

}
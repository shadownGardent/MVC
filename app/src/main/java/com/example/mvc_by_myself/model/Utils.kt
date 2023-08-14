package com.example.mvc_by_myself.model

object Utils {
    fun fakeDate() : List<User> {
        return listOf(
            User("user1", "user1"),
            User("user2", "user2"),
            User("user3", "user3")
        )
    }
}
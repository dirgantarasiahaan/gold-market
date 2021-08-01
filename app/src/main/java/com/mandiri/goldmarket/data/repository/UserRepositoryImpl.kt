package com.mandiri.goldmarket.data.repository

import com.mandiri.goldmarket.data.model.User

class UserRepositoryImpl: UserRepository {

    override fun signUp(user: User): User {
        userDb.add(user)
        return user
    }

    override fun signIn(username: String, password: String): User {
        return User(username,password, "", "")
    }

    companion object{
        val userDb = mutableListOf(User("user","P@ssw0rd", "firstname", "lastname"))
    }
}
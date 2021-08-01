package com.mandiri.goldmarket.data.repository

import com.mandiri.goldmarket.data.model.User

interface UserRepository {
    fun signUp(user: User): User
    fun signIn(username: String, password: String): User
}
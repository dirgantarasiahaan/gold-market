package com.mandiri.goldmarket.data.repository

import com.mandiri.goldmarket.data.model.Profile

interface ProfileRepository {

    fun getProfile(): Profile
}
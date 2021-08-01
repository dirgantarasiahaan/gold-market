package com.mandiri.goldmarket.data.repository

import com.mandiri.goldmarket.data.model.Price
import com.mandiri.goldmarket.data.model.Profile

class ProfileRepositoryImpl: ProfileRepository {
    override fun getProfile(): Profile {
        return profileDB
    }

    companion object{
        val profileDB = Profile("Leo Geprek", "Mobile Developer")
    }
}
package com.mandiri.goldmarket.persentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mandiri.goldmarket.data.model.Profile
import com.mandiri.goldmarket.data.repository.ProfileRepository

class ProfileViewModel: ViewModel() {

    private lateinit var repository: ProfileRepository

    private var _profileLiveData = MutableLiveData<Profile>()

    val priceLiveData: LiveData<Profile>
        get() = _profileLiveData

    private fun getPriceFromRepository() = repository.getProfile()

    fun getData(){
        val profile = getPriceFromRepository()
        _profileLiveData.value = profile

    }

    fun setRepository(repository: ProfileRepository){
        this.repository = repository
    }
}
package com.mandiri.goldmarket.persentation.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mandiri.goldmarket.utils.EventResult

class AuthViewModel: ViewModel() {
    private var _userLiveData = MutableLiveData<EventResult>()

    val userLiveData: LiveData<EventResult>
        get() = _userLiveData

    fun updateInfo(){
        _userLiveData.value = EventResult.Loading
        Handler(Looper.getMainLooper()).postDelayed({
            try {
                _userLiveData.value = EventResult.Success("Successfully")
            } catch ( ex: Exception){
                _userLiveData.value = EventResult.Failed("Upps, something wrong")
            }
        }, 1500)
    }
}
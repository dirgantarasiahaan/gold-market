package com.mandiri.goldmarket.persentation.viewmodel

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mandiri.goldmarket.data.model.Pocket
import com.mandiri.goldmarket.data.repository.PocketRepository
import com.mandiri.goldmarket.utils.EventResult

class PocketViewModel: ViewModel() {

    private lateinit var repository: PocketRepository
    private var _pocketLiveData = MutableLiveData<EventResult>()

    val pocketLiveData: LiveData<EventResult>
        get() = _pocketLiveData

    fun start() {
        updateInfo()
    }

    private fun getHistoryFromRepository() = repository.findAllPocket()

    fun updateInfo(){
        _pocketLiveData.value = EventResult.Loading
        Handler(Looper.getMainLooper()).postDelayed({
            try {
                val history = getHistoryFromRepository()
                Log.d("historyDb", history.toString())
                _pocketLiveData.value = EventResult.Success(history)
            } catch ( ex: Exception){
                _pocketLiveData.value = EventResult.Failed("Upps, something wrong")
            }
        }, 1500)
    }

    fun setRepository(repository: PocketRepository){
        this.repository = repository
    }

    fun addPocket(pocket: Pocket){
        repository.addPocket(pocket)
    }

    fun delPocket(position: Int){
        repository.deletePocket(position)
        updateInfo()
    }
}
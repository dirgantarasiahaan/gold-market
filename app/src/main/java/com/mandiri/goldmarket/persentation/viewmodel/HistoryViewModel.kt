package com.mandiri.goldmarket.persentation.viewmodel

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mandiri.goldmarket.data.repository.HistoryRepository
import com.mandiri.goldmarket.utils.EventResult

class HistoryViewModel: ViewModel() {
    private lateinit var repository: HistoryRepository
    private var _historyLiveData = MutableLiveData<EventResult>()

    val historyLiveData: LiveData<EventResult>
        get() = _historyLiveData

    fun start() {
        updateInfo()
    }

    private fun getHistoryFromRepository() = repository.findAllHistory()

    fun updateInfo(){
        _historyLiveData.value = EventResult.Loading
        Handler(Looper.getMainLooper()).postDelayed({
            try {
                val history = getHistoryFromRepository()
                Log.d("historyDb", history.toString())
                _historyLiveData.value = EventResult.Success(history)
            } catch ( ex: Exception){
                _historyLiveData.value = EventResult.Failed("Upps, something wrong")
            }
        }, 1500)
    }

    fun setRepository(repository: HistoryRepository){
        this.repository = repository
    }
}
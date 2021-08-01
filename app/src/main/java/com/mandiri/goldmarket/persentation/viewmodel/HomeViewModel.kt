package com.mandiri.goldmarket.persentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mandiri.goldmarket.data.model.Price
import com.mandiri.goldmarket.data.repository.PriceRepository

class HomeViewModel: ViewModel() {

    private lateinit var repository: PriceRepository

    private var _priceLiveData = MutableLiveData<Price>()

    val priceLiveData: LiveData<Price>
        get() = _priceLiveData

    private fun getPriceFromRepository() = repository.findPrice()

    fun getData(){
        val price = getPriceFromRepository()
        _priceLiveData.value = price

    }

    fun setRepository(repository: PriceRepository){
        this.repository = repository
    }
}
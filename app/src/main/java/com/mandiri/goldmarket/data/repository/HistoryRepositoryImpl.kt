package com.mandiri.goldmarket.data.repository

import com.mandiri.goldmarket.data.model.History
import com.mandiri.goldmarket.data.model.User

class HistoryRepositoryImpl: HistoryRepository {
    override fun findAllHistory(): List<History> {
        return historyDB
    }

    companion object{
        val historyDB = mutableListOf(History("Pembelian", "20/02/2021"), History("Penjualan", "22/02/2021"))
    }
}
package com.mandiri.goldmarket.data.repository

import com.mandiri.goldmarket.data.model.Pocket

class PocketRepositoryImpl: PocketRepository {
    override fun findAllPocket(): List<Pocket> {
        return pocketDb
    }

    override fun deletePocket(pocket: Int) {
        pocketDb.removeAt(pocket)
    }

    override fun addPocket(pocket: Pocket): Pocket {
        pocketDb.add(pocket)
        return pocket
    }

    companion object{
        val pocketDb = mutableListOf(Pocket("Tabungan Pensiun",3))
    }
}
package com.mandiri.goldmarket.data.repository

import com.mandiri.goldmarket.data.model.Pocket

interface PocketRepository {

    fun addPocket(pocket: Pocket): Pocket
    fun findAllPocket(): List<Pocket>
    fun deletePocket(position: Int)

}
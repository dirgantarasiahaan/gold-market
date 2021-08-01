package com.mandiri.goldmarket.data.repository

import com.mandiri.goldmarket.data.model.Price

interface PriceRepository {
    fun findPrice(): Price
}
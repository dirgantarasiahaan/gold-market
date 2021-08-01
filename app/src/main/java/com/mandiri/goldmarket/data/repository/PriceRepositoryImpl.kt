package com.mandiri.goldmarket.data.repository

import com.mandiri.goldmarket.data.model.Price

class PriceRepositoryImpl: PriceRepository {
    override fun findPrice(): Price {
        return priceDb
    }

    companion object{
        val priceDb = Price("Rp.888.888","Rp.777.777", "RP.999.999")
    }
}
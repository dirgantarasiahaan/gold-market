package com.mandiri.goldmarket.data.repository

import com.mandiri.goldmarket.data.model.History

interface HistoryRepository {
    fun findAllHistory(): List<History>
}
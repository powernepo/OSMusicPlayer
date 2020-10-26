package com.powernepo.offline.domain.repository

import com.powernepo.offline.domain.model.Mobile

interface MobileRepository {
    fun insert(mobile: Mobile): Long
}
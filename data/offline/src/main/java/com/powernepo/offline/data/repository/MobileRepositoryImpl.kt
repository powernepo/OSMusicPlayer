package com.powernepo.offline.data.repository

import com.powernepo.offline.domain.model.Mobile
import com.powernepo.offline.domain.repository.MobileRepository
import com.powernepo.offline.room.dao.MobileDao
import javax.inject.Inject

typealias Entity = com.powernepo.offline.data.entity.Mobile

class MobileRepositoryImpl @Inject constructor(
    private val mobileDao: MobileDao
) : MobileRepository {

    override fun insert(mobile: Mobile) =
        mobileDao.insert(
            mobile = Entity(
                id = mobile.id
            )
        )
}
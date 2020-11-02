package com.powernepo.offline.data.mapper

import com.powernepo.offline.data.entity.Mobile

typealias Model = com.powernepo.offline.domain.model.Mobile

fun Mobile.toDomainModel() = Model(
    id = id!!
)
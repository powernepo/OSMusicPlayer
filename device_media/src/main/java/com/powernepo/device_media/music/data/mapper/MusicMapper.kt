package com.powernepo.device_media.music.data.mapper

import com.powernepo.device_media.music.data.entity.Music

typealias Entity = Music
typealias Model = com.powernepo.device_media.music.domain.model.Music

fun Entity.toDomainModel() = Model(
    id = id,
    data = data
)
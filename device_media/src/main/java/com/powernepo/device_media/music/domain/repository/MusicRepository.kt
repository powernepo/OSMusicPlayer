package com.powernepo.device_media.music.domain.repository

import com.powernepo.device_media.music.domain.model.Music

interface MusicRepository {
    suspend fun all(): List<Music>
}
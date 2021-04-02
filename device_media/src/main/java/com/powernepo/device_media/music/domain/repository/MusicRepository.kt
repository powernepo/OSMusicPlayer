package com.powernepo.device_media.music.domain.repository

import com.powernepo.device_media.music.domain.model.Music

interface MusicRepository {
    suspend fun all(): List<Music>
    suspend fun all(id: String): List<Music>
    suspend fun allMusics() : List<Music>
}
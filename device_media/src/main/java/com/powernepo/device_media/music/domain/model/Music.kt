package com.powernepo.device_media.music.domain.model

data class Music(
    val id: String,
    val relativePath: String,
    val data: String,
    val albumId: String
)
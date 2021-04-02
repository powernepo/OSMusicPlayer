package com.powernepo.device_media.music.domain.model

data class Music(
    val id: String,
    val data: String,
    val albumId: String,
    val album: String,
    val title: String,
    val duration: String,
    val artist: String,
    val displayName: String,
    val artistId: String,
    val relativePath: String,
    val mimeType: String,
    val dateModified: String,
)
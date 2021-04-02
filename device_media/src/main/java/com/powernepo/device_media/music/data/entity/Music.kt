package com.powernepo.device_media.music.data.entity

import android.provider.MediaStore
import com.powernepo.device_content.annotation.Column


//MediaStore.Audio.Media.EXTERNAL_CONTENT_URI

data class Music(
    @Column(0, MediaStore.Audio.Media._ID)
    val id: String,
    @Column(1, MediaStore.Audio.Media.DATA)
    val data: String,
    @Column(2, MediaStore.Audio.Media.ALBUM_ID)
    val albumId: String,
    @Column(3, MediaStore.Audio.Media.ALBUM)
    val album: String,
    @Column(4, MediaStore.Audio.Media.TITLE)
    val title: String,
    @Column(5, MediaStore.Audio.Media.DURATION)
    val duration: String,
    @Column(6, MediaStore.Audio.Media.ARTIST)
    val artist: String,
    @Column(7, MediaStore.Audio.Media.DISPLAY_NAME)
    val displayName: String,
    @Column(8, MediaStore.Audio.Media.ARTIST_ID)
    val artistId: String,
    @Column(9, MediaStore.Audio.Media.RELATIVE_PATH)
    val relativePath: String,
    @Column(10, MediaStore.Audio.Media.MIME_TYPE)
    val mimeType: String,
    @Column(11, MediaStore.Audio.Media.DATE_MODIFIED)
    val dateModified: String,
)
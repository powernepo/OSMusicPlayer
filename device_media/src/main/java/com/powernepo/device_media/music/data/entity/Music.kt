package com.powernepo.device_media.music.data.entity

import android.provider.MediaStore
import com.powernepo.device_content.annotation.Column

data class Music(
    @Column(1, MediaStore.Audio.Media._ID)
    val id: String,

    @Column(2, MediaStore.Audio.Media.DATA)
    val data: String,
)
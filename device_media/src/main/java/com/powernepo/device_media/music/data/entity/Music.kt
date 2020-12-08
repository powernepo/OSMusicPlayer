package com.powernepo.device_media.music.data.entity

import android.provider.MediaStore
import com.powernepo.device_content.annotation.Column

data class Music(
    @Column(MediaStore.Audio.Media._ID)
    val id: String,

    @Column(MediaStore.Audio.Media._COUNT)
    val count: Int,

    @Column(MediaStore.Audio.Media.DATA)
    val data: String,
)
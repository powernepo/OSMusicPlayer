package com.powernepo.device_media.music.data.entity

import android.os.Build
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import com.powernepo.device_content.annotation.Column

@RequiresApi(Build.VERSION_CODES.Q)
data class Music constructor(
    @Column(1, MediaStore.Audio.Media._ID)
    val id: String,

    @Column(2, MediaStore.Audio.Media.RELATIVE_PATH)
    val relativePath: String,

    @Column(3, MediaStore.Audio.Media.DATA)
    val data: String,

    @Column(4, MediaStore.Audio.Albums._ID)
    val albumId: String
)
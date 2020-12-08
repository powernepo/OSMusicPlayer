package com.powernepo.device_content.mock

import android.provider.MediaStore
import com.powernepo.device_content.annotation.Column

class Car(
    @Column(MediaStore.Audio.Media.ALBUM)
    val name: String
)
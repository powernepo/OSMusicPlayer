package com.powernepo.device_media.music.data.repository

import android.content.Context
import android.database.Cursor
import android.provider.MediaStore
import android.provider.UserDictionary
import android.util.Log
import com.powernepo.device_media.music.domain.model.Music
import com.powernepo.device_media.music.domain.repository.MusicRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber
import java.sql.Blob
import javax.inject.Inject

class MusicRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : MusicRepository {

    override suspend fun all(): List<Music> {
        return mutableListOf<Music>()
    }
}
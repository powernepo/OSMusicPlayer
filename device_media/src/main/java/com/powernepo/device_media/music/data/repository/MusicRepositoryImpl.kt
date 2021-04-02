package com.powernepo.device_media.music.data.repository

import android.provider.MediaStore
import com.powernepo.device_content.generator.ContentGenerator
import com.powernepo.device_media.music.data.mapper.toDomainModel
import com.powernepo.device_media.music.domain.model.Music
import com.powernepo.device_media.music.domain.repository.MusicRepository
import javax.inject.Inject

typealias Entity = com.powernepo.device_media.music.data.entity.Music

class MusicRepositoryImpl @Inject constructor(
    private val contentGenerator: ContentGenerator<Entity>
) : MusicRepository {

    override suspend fun all() = contentGenerator.generate().map {
        it.toDomainModel()
    }

    override suspend fun all(id: String) = contentGenerator.generate(
        selection = "${MediaStore.Audio.Media._ID} = ?",
        selectionArgs = arrayOf(id)
    ).map {
        it.toDomainModel()
    }

    override suspend fun allMusics() = contentGenerator.generate(
        selection = "${MediaStore.Audio.Media.IS_MUSIC} = ?",
        selectionArgs = arrayOf("1")
    ).map {
        it.toDomainModel()
    }
}
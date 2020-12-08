package com.powernepo.device_media.music.data.repository

import com.powernepo.device_content.generator.ContentGenerator
import com.powernepo.device_media.music.data.mapper.toDomainModel
import com.powernepo.device_media.music.domain.repository.MusicRepository
import javax.inject.Inject

typealias Entity = com.powernepo.device_media.music.data.entity.Music

class MusicRepositoryImpl @Inject constructor(
    private val contentGenerator: ContentGenerator<Entity>
) : MusicRepository {

    override suspend fun all() = contentGenerator.generate().map {
        it.toDomainModel()
    }
}
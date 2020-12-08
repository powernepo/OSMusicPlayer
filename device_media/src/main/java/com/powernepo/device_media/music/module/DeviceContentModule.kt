package com.powernepo.device_media.music.module

import android.content.Context
import android.provider.MediaStore
import com.powernepo.device_content.extension.generate
import com.powernepo.device_content.generator.ContentGenerator
import com.powernepo.device_content.generator.ContentGeneratorImpl
import com.powernepo.device_media.music.data.entity.Music
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext

typealias Entity = Music

@Module
@InstallIn(FragmentComponent::class)
class DeviceContentModule {
    @Provides
    fun providesMusicContentBuilder(@ApplicationContext context: Context) =
        generate<Entity>(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, context)
}
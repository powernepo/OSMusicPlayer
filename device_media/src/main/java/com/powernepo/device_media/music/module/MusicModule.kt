package com.powernepo.device_media.music.module

import com.powernepo.device_media.music.data.repository.MusicRepositoryImpl
import com.powernepo.device_media.music.domain.repository.MusicRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ServiceComponent

@Module
@InstallIn(ServiceComponent::class)
abstract class MusicModule {
    @Binds
    abstract fun bindsMusicRepository(impl: MusicRepositoryImpl): MusicRepository
}
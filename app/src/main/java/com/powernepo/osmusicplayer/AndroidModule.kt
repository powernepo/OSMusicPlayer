package com.powernepo.osmusicplayer

import android.app.NotificationManager
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ServiceComponent::class)
class AndroidModule {
    @Provides
    fun providesNotificationManager(@ApplicationContext c: Context): NotificationManager =
        c.getSystemService(NotificationManager::class.java)
}
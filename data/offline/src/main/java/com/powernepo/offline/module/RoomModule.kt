package com.powernepo.offline.module

import android.content.Context
import androidx.room.Room
import com.powernepo.offline.room.builder.Database
import com.powernepo.offline.room.builder.databaseName
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun providesDatabase(context: Context): Database = Room.databaseBuilder(
        context,
        Database::class.java,
        databaseName
    ).build()

    @Provides
    @Singleton
    fun providesMobileDao(database: Database) = database.mobileDao()
}
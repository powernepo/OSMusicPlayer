package com.powernepo.offline.module

import android.content.Context
import androidx.room.Room
import com.powernepo.offline.room.builder.Database
import com.powernepo.offline.room.builder.databaseName
import com.powernepo.offline.room.migrations.MigrationFrom1To2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RoomModule {

    @Provides
    @Singleton
    fun providesDatabase(
        @ApplicationContext context: Context
    ): Database = Room.databaseBuilder(
        context,
        Database::class.java,
        databaseName
    ).allowMainThreadQueries().addMigrations(
        MigrationFrom1To2()
    ).build()

    @Provides
    @Singleton
    fun providesMobileDao(database: Database) =
        database.mobileDao()
}
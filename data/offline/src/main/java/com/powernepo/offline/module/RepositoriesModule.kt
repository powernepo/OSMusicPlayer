package com.powernepo.offline.module

import com.powernepo.offline.data.repository.MobileRepositoryImpl
import com.powernepo.offline.domain.repository.MobileRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun providesMobileRepository(mobileRepositoryImpl: MobileRepositoryImpl)
            : MobileRepository
}
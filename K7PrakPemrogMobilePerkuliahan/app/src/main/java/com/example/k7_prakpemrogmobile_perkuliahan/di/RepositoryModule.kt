package com.example.k7_prakpemrogmobile_perkuliahan.di

import com.example.k7_prakpemrogmobile_perkuliahan.networks.MatkulApi
import com.example.k7_prakpemrogmobile_perkuliahan.persistences.MatkulDao
import com.example.k7_prakpemrogmobile_perkuliahan.repositories.MatkulRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    @ViewModelScoped
    fun provideMatkulRepository(
        api: MatkulApi,
        dao: MatkulDao
    ): MatkulRepository {
        return MatkulRepository(api, dao)
    }
}
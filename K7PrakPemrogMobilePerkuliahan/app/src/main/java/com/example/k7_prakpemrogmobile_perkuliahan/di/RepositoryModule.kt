package com.example.k7_prakpemrogmobile_perkuliahan.di

import com.example.k7_prakpemrogmobile_perkuliahan.networks.DosenApi
import com.example.k7_prakpemrogmobile_perkuliahan.networks.MahasiswaApi
import com.example.k7_prakpemrogmobile_perkuliahan.networks.MatkulApi
import com.example.k7_prakpemrogmobile_perkuliahan.persistences.DosenDao
import com.example.k7_prakpemrogmobile_perkuliahan.persistences.MahasiswaDao
import com.example.k7_prakpemrogmobile_perkuliahan.persistences.MatkulDao
import com.example.k7_prakpemrogmobile_perkuliahan.repositories.DosenRepository
import com.example.k7_prakpemrogmobile_perkuliahan.repositories.MahasiswaRepository
import com.example.k7_prakpemrogmobile_perkuliahan.repositories.MatkulRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
//    dosen
    @Provides
    @ViewModelScoped
    fun provideDosenRepository(
        api: DosenApi,
        dao: DosenDao
    ): DosenRepository {
        return DosenRepository(api, dao)
    }

//    mahasiswa
    @Provides
    @ViewModelScoped
    fun provideMahasiswaRepository(
        api: MahasiswaApi,
        dao: MahasiswaDao
    ): MahasiswaRepository {
        return MahasiswaRepository(api, dao)
    }

//    matkul
    @Provides
    @ViewModelScoped
    fun provideMatkulRepository(
        api: MatkulApi,
        dao: MatkulDao
    ): MatkulRepository {
        return MatkulRepository(api, dao)
    }
}
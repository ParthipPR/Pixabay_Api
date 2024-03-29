package com.Parthip.pixabay.di

import com.Parthip.pixabay.imageList.data.repository.ImageListRepositoryImpl
import com.Parthip.pixabay.imageList.domain.repository.ImageListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindImageListRepository(
        imageListRepositoryImpl: ImageListRepositoryImpl
    ): ImageListRepository

}
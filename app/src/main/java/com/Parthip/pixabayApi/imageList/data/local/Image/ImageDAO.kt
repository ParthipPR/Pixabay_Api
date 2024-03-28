package com.Parthip.pixabayApi.imageList.data.local.Image

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface ImageDAO {

    @Upsert
    suspend fun upsertImageList(imageList: List<ImageEntity>)

    @Query("SELECT * FROM ImageEntity WHERE id = :id")
    suspend fun getImageById(id: Int): ImageEntity

    @Query("SELECT * FROM ImageEntity ")
    suspend fun getImageList(): List<ImageEntity>
}
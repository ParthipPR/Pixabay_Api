package com.Parthip.pixabayApi.imageList.data.local.Image

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ImageEntity::class],
    version = 1
)
abstract class ImageDatabase: RoomDatabase() {
    abstract val imageDAO: ImageDAO
}
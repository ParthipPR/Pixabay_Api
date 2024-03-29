package com.Parthip.pixabay.imageList.data.local.Image

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ImageEntity::class],
    version = 1
)
abstract class ImageDatabase: RoomDatabase() {
    abstract val imageDAO: ImageDAO
}
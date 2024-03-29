package com.Parthip.pixabay.imageList.domain.repository

import com.Parthip.pixabay.imageList.domain.model.Image
import com.Parthip.pixabay.utils.Resource
import kotlinx.coroutines.flow.Flow


interface ImageListRepository {

    suspend fun getImageList(
        forceFetchFromRemote: Boolean
    ) : Flow<Resource<List<Image>>>

    suspend fun getImage( id: Int ) : Flow<Resource<Image>>
}
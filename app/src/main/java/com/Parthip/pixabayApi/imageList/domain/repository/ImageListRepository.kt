package com.Parthip.pixabayApi.imageList.domain.repository

import com.Parthip.pixabayApi.imageList.domain.model.Image
import com.Parthip.pixabayApi.utils.Resource
import kotlinx.coroutines.flow.Flow


interface ImageListRepository {

    suspend fun getImageList(
        forceFetchFromRemote: Boolean,
        page: Int,
        perpage: Int
    ) : Flow<Resource<List<Image>>>

    suspend fun getImage( id: Int ) : Flow<Resource<Image>>
}
package com.Parthip.pixabayApi.imageList.data.remote.respond

data class ImageListDTO(
    val hits: List<ImageDTO>,
    val total: Int,
    val totalHits: Int
)
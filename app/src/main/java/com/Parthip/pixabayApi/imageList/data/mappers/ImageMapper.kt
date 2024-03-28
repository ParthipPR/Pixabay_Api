package com.Parthip.pixabayApi.imageList.data.mappers

import com.Parthip.pixabayApi.imageList.data.local.Image.ImageEntity
import com.Parthip.pixabayApi.imageList.data.remote.respond.ImageDTO
import com.Parthip.pixabayApi.imageList.domain.model.Image


fun ImageEntity.toImage() : Image{
    return Image(
        collections = collections ?: 0,
        comments = comments ?: 0,
        downloads = downloads ?: 0,
        imageHeight = imageHeight ?: 0,
        imageSize = imageSize ?: 0,
        imageWidth = imageWidth ?: 0,
        largeImageURL = largeImageURL ?: "",
        likes = likes ?: 0,
        pageURL = pageURL ?: "",
        previewHeight = previewHeight ?: 0,
        previewURL = previewURL ?: "",
        previewWidth = previewWidth ?: 0,
        tags = tags ?: "",
        type = type ?: "",
        user = user ?: "",
        userImageURL = userImageURL ?: "",
        user_id = user_id ?: 0,
        views = views ?: 0,
        webformatHeight = webformatHeight ?: 0,
        webformatURL = webformatURL ?: "",
        webformatWidth = webformatWidth ?: 0,
        id = id ?: 0
    )
}

fun ImageDTO.toImage(): ImageEntity {
    return ImageEntity(
        collections = collections ?: 0,
        comments = comments ?: 0,
        downloads = downloads ?: 0,
        imageHeight = imageHeight ?: 0,
        imageSize = imageSize ?: 0,
        imageWidth = imageWidth ?: 0,
        largeImageURL = largeImageURL ?: "",
        likes = likes ?: 0,
        pageURL = pageURL ?: "",
        previewHeight = previewHeight ?: 0,
        previewURL = previewURL ?: "",
        previewWidth = previewWidth ?: 0,
        tags = tags ?: "",
        type = type ?: "",
        user = user ?: "",
        userImageURL = userImageURL ?: "",
        user_id = user_id ?: 0,
        views = views ?: 0,
        webformatHeight = webformatHeight ?: 0,
        webformatURL = webformatURL ?: "",
        webformatWidth = webformatWidth ?: 0,
        id = id ?: 0
    )
}
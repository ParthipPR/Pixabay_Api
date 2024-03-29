package com.Parthip.pixabay.imageList.presentation

import com.Parthip.pixabay.imageList.domain.model.Image

data class ImageListState(
    val isLoading: Boolean = false,
    val mainImageListPage: Int = 1,
    val isCurrentMainScreen: Boolean = true,
    val mainImageList: List<Image> = emptyList()
)
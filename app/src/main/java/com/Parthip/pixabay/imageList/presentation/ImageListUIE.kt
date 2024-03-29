package com.Parthip.pixabay.imageList.presentation

sealed interface ImageListUIE {

    data class Paginate(val type: String) :ImageListUIE
    object Navigate : ImageListUIE
}

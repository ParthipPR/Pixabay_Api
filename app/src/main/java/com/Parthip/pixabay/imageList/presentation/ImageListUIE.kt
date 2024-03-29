package com.Parthip.pixabay.imageList.presentation

sealed interface ImageListUIE {

    data class Paginate(val perpage: Int) :ImageListUIE
    object Navigate : ImageListUIE
}

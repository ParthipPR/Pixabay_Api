package com.Parthip.pixabay.imageList.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Parthip.pixabay.imageList.domain.repository.ImageListRepository
import com.Parthip.pixabay.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageListViewModel @Inject constructor(
    private val imageListRepository: ImageListRepository
) : ViewModel() {

    private var _imageListState = MutableStateFlow(ImageListState())
    val imageListState = _imageListState.asStateFlow()

    init {
        getImageList(false)
    }

    fun onEvent(event: ImageListUIE) {
        when (event) {
            is ImageListUIE.Navigate -> {
                _imageListState.update {
                    it.copy(
                        isCurrentMainScreen = !imageListState.value.isCurrentMainScreen
                    )
                }
            }

            is ImageListUIE.Paginate -> {
                getImageList(true)
            }
        }
    }

    fun getImageList(forceFetchFromRemote: Boolean) {
        viewModelScope.launch {
            _imageListState.update {
                it.copy(isLoading = true)
            }

            imageListRepository.getImageList(forceFetchFromRemote).collectLatest { hits ->
                when (hits) {
                    is Resource.Error -> {
                        _imageListState.update {
                            it.copy(isLoading = false)
                        }
                    }

                    is Resource.Success -> {
                        hits.data?.let { imageList ->
                            _imageListState.update {
                                it.copy(
                                    mainImageList =  imageListState.value.mainImageList  + imageList.shuffled(),
                                    mainImageListPage = imageListState.value.mainImageListPage + 1
                                )
                            }
                        }
                    }

                    is Resource.Loading -> {
                        _imageListState.update {
                            it.copy(isLoading = hits.isLoading)
                        }
                    }
                }
            }
        }
    }
}

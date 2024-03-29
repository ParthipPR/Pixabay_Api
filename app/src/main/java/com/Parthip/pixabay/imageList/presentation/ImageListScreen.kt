package com.Parthip.pixabay.imageList.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.Parthip.pixabay.imageList.presentation.components.ImageItem

@Composable
fun ImageListScreen(
    imageListState: ImageListState,
    navController: NavController,
    onEvent: (ImageListUIE) -> Unit
) {
    if (imageListState.mainImageList.isEmpty()){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
    else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = 4.dp)
        ){
            items(imageListState.mainImageList.size){index ->
                ImageItem(
                    image = imageListState.mainImageList[index],
                    navController = navController
                )
                Spacer(modifier = Modifier.height(16.dp))

                if (index >= imageListState.mainImageList.size - 1 && !imageListState.isLoading){
                    onEvent(ImageListUIE.Paginate(type = "Photo"))
                }

            }
        }
    }

}
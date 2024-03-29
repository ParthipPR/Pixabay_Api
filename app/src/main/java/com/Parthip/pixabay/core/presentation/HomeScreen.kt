package com.Parthip.pixabay.core.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.Parthip.pixabay.R
import com.Parthip.pixabay.imageList.presentation.ImageListScreen
import com.Parthip.pixabay.imageList.presentation.ImageListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {

    val imageListViewModel = hiltViewModel<ImageListViewModel>()
    val imageListState = imageListViewModel.imageListState.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = if (imageListState.isCurrentMainScreen)
                        stringResource(R.string.main_page)
                    else
                        stringResource(R.string.details_page),
                    fontSize = 20.sp
                )},
                modifier = Modifier.shadow(2.dp),
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    MaterialTheme.colorScheme.inverseOnSurface)
                )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ){
              ImageListScreen(
                  imageListState = imageListState,
                  navController = navController,
                  onEvent = imageListViewModel::onEvent
              )

        }
    }

}
package com.andriuswill.rickandmortyapp.ui.detail.episode

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.andriuswill.rickandmortyapp.extensions.getIdFromUrl
import com.andriuswill.rickandmortyapp.ui.component.EpisodeCard
import com.andriuswill.rickandmortyapp.ui.navigation.NavigationItemDetail


@ExperimentalMaterialApi
@Composable
fun EpisodeDetailScreen(
    viewModel: EpisodeDetailViewModel,
    navController: NavHostController
) {

    val episodeDetail = viewModel.episodeDetailState.value

    LazyColumn(
        contentPadding = PaddingValues(4.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(episodeDetail?.characters.orEmpty()) { url ->
            EpisodeCard(
                episodeName = url,
                episodeInfo= url
            ) {
                navController.navigate(
                    route = NavigationItemDetail
                        .CharactersDetail
                        .getWithArg(url.getIdFromUrl()),
                )
            }
        }
    }

}
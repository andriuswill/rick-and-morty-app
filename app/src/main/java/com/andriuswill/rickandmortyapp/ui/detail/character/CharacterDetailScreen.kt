package com.andriuswill.rickandmortyapp.ui.detail.character

import androidx.compose.foundation.layout.Column
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
import com.andriuswill.rickandmortyapp.ui.component.LocationCard
import com.andriuswill.rickandmortyapp.ui.navigation.NavigationDetailItem

@ExperimentalMaterialApi
@Composable
fun CharacterDetailScreen(
    viewModel: CharacterDetailViewModel,
    navController: NavHostController
) {

    val characterDetail = viewModel.characterDetailState.value

    Column {

        LocationCard(
            locationName = characterDetail?.location?.name.orEmpty()
        ) {
            navController.navigate(
                route = NavigationDetailItem
                    .LocationDetail
                    .getWithArg(
                        characterDetail?.location?.url?.getIdFromUrl().orEmpty()
                    )
            )
        }

        LazyColumn(
            contentPadding = PaddingValues(4.dp),
            modifier = Modifier.fillMaxSize()
        ) {

            items(characterDetail?.episode.orEmpty()) { url ->
                LocationCard(
                    locationName = url
                ) {
                    navController.navigate(
                        route = NavigationDetailItem
                            .EpisodeDetail
                            .getWithArg(url.getIdFromUrl()),
                    )
                }
            }
        }
    }


}
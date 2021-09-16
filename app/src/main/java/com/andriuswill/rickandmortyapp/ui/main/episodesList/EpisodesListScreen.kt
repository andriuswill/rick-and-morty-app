package com.andriuswill.rickandmortyapp.ui.main.charactersList

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andriuswill.rickandmortyapp.extensions.getIdFromUrl
import com.andriuswill.rickandmortyapp.ui.component.EpisodeCard
import com.andriuswill.rickandmortyapp.ui.navigation.NavigationItemDetail
import com.andriuswill.rickandmortyapp.ui.detail.DetailActivity
import com.andriuswill.rickandmortyapp.ui.main.episodesList.EpisodesListViewModel

@ExperimentalMaterialApi
@Composable
fun EpisodesListScreen(
    viewModel: EpisodesListViewModel
) {
    val context = LocalContext.current

    val episodes = viewModel.episodesState.value

    viewModel.getEpisodes()

    LazyColumn(
        contentPadding = PaddingValues(4.dp),
        modifier = Modifier.fillMaxSize()
    ) {

        items(episodes) { item ->
            EpisodeCard(
                episodeName = item.name,
                episodeInfo= item.episode
            ) {
                DetailActivity.start(
                    context,
                    NavigationItemDetail.EpisodeDetail.route,
                    item.url.getIdFromUrl()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    //EpisodesScreen()
}
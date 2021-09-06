package com.andriuswill.rickandmortyapp.ui.main.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.andriuswill.rickandmortyapp.ui.main.MainViewModel

@Composable
fun EpisodesScreen(viewModel: MainViewModel) {

    val episodes = viewModel.episodesState.value

    viewModel.getEpisodes()

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Episodes")

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    //EpisodesScreen()
}
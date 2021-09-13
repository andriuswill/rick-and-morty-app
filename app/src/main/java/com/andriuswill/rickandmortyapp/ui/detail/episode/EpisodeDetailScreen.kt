package com.andriuswill.rickandmortyapp.ui.detail.episode

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController


@Composable
fun EpisodeDetailScreen(
    viewModel: EpisodeDetailViewModel,
    navController: NavHostController,
    url: String
) {
    Text(text = url)
}
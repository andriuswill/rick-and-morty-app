package com.andriuswill.rickandmortyapp.ui.detail.character

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun CharacterDetailScreen(
    viewModel: CharacterDetailViewModel,
    navController: NavHostController,
    url: String
) {
    Text(text = url)
}
package com.andriuswill.rickandmortyapp.ui.detail.location

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

class LocationScreen

@Composable
fun LocationDetailScreen(
    viewModel: LocationDetailViewModel,
    navController: NavHostController,
    url: String
) {
    Text(text = url)
}
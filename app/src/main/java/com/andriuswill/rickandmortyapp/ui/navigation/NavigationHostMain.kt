package com.andriuswill.rickandmortyapp.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.andriuswill.rickandmortyapp.ui.characters.CharactersListScreen
import com.andriuswill.rickandmortyapp.ui.location.LocationsListScreen
import com.andriuswill.rickandmortyapp.ui.main.charactersList.CharactersListViewModel
import com.andriuswill.rickandmortyapp.ui.main.charactersList.EpisodesListScreen
import com.andriuswill.rickandmortyapp.ui.main.episodesList.EpisodesListViewModel
import com.andriuswill.rickandmortyapp.ui.main.locationsList.LocationsListViewModel

@ExperimentalCoilApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun NavigationHostMain(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationItemMain.CharactersList.route
    ) {
        composable(NavigationItemMain.CharactersList.route) {
            val viewModel: CharactersListViewModel = hiltViewModel(it)
            CharactersListScreen(viewModel = viewModel)
        }
        composable(NavigationItemMain.LocationsList.route) {
            val viewModel: LocationsListViewModel = hiltViewModel(it)
            LocationsListScreen(viewModel = viewModel)
        }
        composable(NavigationItemMain.EpisodesList.route) {
            val viewModel: EpisodesListViewModel = hiltViewModel(it)
            EpisodesListScreen(viewModel = viewModel)
        }
    }
}
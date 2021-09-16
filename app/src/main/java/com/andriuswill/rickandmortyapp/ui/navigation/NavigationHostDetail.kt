package com.andriuswill.rickandmortyapp.ui.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.andriuswill.rickandmortyapp.constants.Constant
import com.andriuswill.rickandmortyapp.ui.detail.character.CharacterDetailScreen
import com.andriuswill.rickandmortyapp.ui.detail.character.CharacterDetailViewModel
import com.andriuswill.rickandmortyapp.ui.detail.episode.EpisodeDetailScreen
import com.andriuswill.rickandmortyapp.ui.detail.episode.EpisodeDetailViewModel
import com.andriuswill.rickandmortyapp.ui.detail.location.LocationDetailScreen
import com.andriuswill.rickandmortyapp.ui.detail.location.LocationDetailViewModel

@ExperimentalMaterialApi
@Composable
fun NavigationHostDetail(
    navController: NavHostController,
    route: String,
    url: String
) {
    NavHost(
        navController = navController,
        startDestination = route
    ) {

        composable(
            route = NavigationItemDetail.CharactersDetail.route,
            arguments = listOf(navArgument(Constant.ARG_CHARACTER_ID) {
                type = NavType.StringType
                defaultValue = url
            })
        ) { navBackStacyEntry ->
            val viewModel: CharacterDetailViewModel = hiltViewModel(navBackStacyEntry)
            CharacterDetailScreen(
                viewModel = viewModel,
                navController = navController
            )
        }

        composable(
            route = NavigationItemDetail.LocationDetail.route,
            arguments = listOf(navArgument(Constant.ARG_LOCATION_ID) {
                type = NavType.StringType
                defaultValue = url
            })
        ) { navBackStacyEntry ->
            val viewModel: LocationDetailViewModel = hiltViewModel(navBackStacyEntry)
            LocationDetailScreen(
                viewModel = viewModel,
                navController = navController
            )
        }

        composable(
            route = NavigationItemDetail.EpisodeDetail.route,
            arguments = listOf(navArgument(Constant.ARG_EPISODE_ID) {
                type = NavType.StringType
                defaultValue = url
            })
        ) { navBackStacyEntry ->
            val viewModel: EpisodeDetailViewModel = hiltViewModel(navBackStacyEntry)
            EpisodeDetailScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
    }
}

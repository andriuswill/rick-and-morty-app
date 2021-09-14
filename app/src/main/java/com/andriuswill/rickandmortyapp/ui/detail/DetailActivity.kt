package com.andriuswill.rickandmortyapp.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.andriuswill.rickandmortyapp.constants.Constant.ARG_CHARACTER_ID
import com.andriuswill.rickandmortyapp.constants.Constant.ARG_EPISODE_ID
import com.andriuswill.rickandmortyapp.constants.Constant.ARG_LOCATION_ID
import com.andriuswill.rickandmortyapp.ui.navigation.NavigationDetailItem
import com.andriuswill.rickandmortyapp.ui.detail.character.CharacterDetailScreen
import com.andriuswill.rickandmortyapp.ui.detail.character.CharacterDetailViewModel
import com.andriuswill.rickandmortyapp.ui.detail.episode.EpisodeDetailScreen
import com.andriuswill.rickandmortyapp.ui.detail.episode.EpisodeDetailViewModel
import com.andriuswill.rickandmortyapp.ui.detail.location.LocationDetailScreen
import com.andriuswill.rickandmortyapp.ui.detail.location.LocationDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterialApi
@AndroidEntryPoint
class DetailActivity : ComponentActivity() {

    private val route: String? by lazy { intent.getStringExtra(EXTRA_ROUTE) }
    private val id: String? by lazy { intent.getStringExtra(EXTRA_ID) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DetailScreen(
                route.orEmpty(),
                id.orEmpty()
            )
        }
    }

    companion object {
        const val EXTRA_ROUTE = "EXTRA_ROUTE"
        const val EXTRA_ID = "EXTRA_ID"
        fun start(
            context: Context,
            route: String,
            id: String
        ) {
            context.startActivity(
                Intent(context, DetailActivity::class.java).apply {
                    putExtra(EXTRA_ROUTE, route)
                    putExtra(EXTRA_ID, id)
                }
            )
        }
    }
}


@ExperimentalMaterialApi
@Composable
fun DetailScreen(route: String, id: String) {
    val navController = rememberNavController()

    Navigation(
        navController = navController,
        route = route,
        url = id
    )

}

@ExperimentalMaterialApi
@Composable
fun Navigation(
    navController: NavHostController,
    route: String,
    url: String
) {
    NavHost(
        navController = navController,
        startDestination = route
    ) {

        composable(
            route = route,
            arguments = listOf(navArgument(ARG_CHARACTER_ID) {
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
            route = NavigationDetailItem.LocationDetail.route,
            arguments = listOf(navArgument(ARG_LOCATION_ID) {
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
            route = NavigationDetailItem.EpisodeDetail.route,
            arguments = listOf(navArgument(ARG_EPISODE_ID) {
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



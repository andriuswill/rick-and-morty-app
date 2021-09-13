package com.andriuswill.rickandmortyapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.andriuswill.rickandmortyapp.ui.component.navigation.NavigationMainItem
import dagger.hilt.android.AndroidEntryPoint
import com.andriuswill.rickandmortyapp.R
import com.andriuswill.rickandmortyapp.ui.characters.CharactersListScreen
import com.andriuswill.rickandmortyapp.ui.location.LocationsListScreen
import com.andriuswill.rickandmortyapp.ui.main.charactersList.CharactersListViewModel
import com.andriuswill.rickandmortyapp.ui.main.charactersList.EpisodesListScreen
import com.andriuswill.rickandmortyapp.ui.main.episodesList.EpisodesListViewModel
import com.andriuswill.rickandmortyapp.ui.main.locationsList.LocationsListViewModel

@ExperimentalCoilApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@ExperimentalCoilApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        }
    ) {
        Navigation(
            navController = navController
        )
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name)) },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.secondary
    )
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationMainItem.CharactersList,
        NavigationMainItem.LocationsList,
        NavigationMainItem.EpisodesList
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.secondary
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(item.icon, item.title)
                },
                label = {
                    Text(text = item.title)
                },
                alwaysShowLabel = true,
                selected = false,
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = Color.White.copy(0.4f),
                onClick = {
                    navController.navigate(item.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@ExperimentalCoilApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationMainItem.CharactersList.route
    ) {
        composable(NavigationMainItem.CharactersList.route) {
            val viewModel: CharactersListViewModel = hiltViewModel(it)
            CharactersListScreen(viewModel = viewModel)
        }
        composable(NavigationMainItem.LocationsList.route) {
            val viewModel: LocationsListViewModel = hiltViewModel(it)
            LocationsListScreen(viewModel = viewModel)
        }
        composable(NavigationMainItem.EpisodesList.route) {
            val viewModel: EpisodesListViewModel = hiltViewModel(it)
            EpisodesListScreen(viewModel = viewModel)
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}

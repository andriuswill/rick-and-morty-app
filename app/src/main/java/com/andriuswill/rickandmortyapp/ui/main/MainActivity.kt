package com.andriuswill.rickandmortyapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.andriuswill.rickandmortyapp.ui.navigation.NavigationItemMain
import dagger.hilt.android.AndroidEntryPoint
import com.andriuswill.rickandmortyapp.R
import com.andriuswill.rickandmortyapp.ui.characters.CharactersListScreen
import com.andriuswill.rickandmortyapp.ui.location.LocationsListScreen
import com.andriuswill.rickandmortyapp.ui.main.charactersList.CharactersListViewModel
import com.andriuswill.rickandmortyapp.ui.main.charactersList.EpisodesListScreen
import com.andriuswill.rickandmortyapp.ui.main.episodesList.EpisodesListViewModel
import com.andriuswill.rickandmortyapp.ui.main.locationsList.LocationsListViewModel
import com.andriuswill.rickandmortyapp.ui.navigation.NavigationHostMain
import com.andriuswill.rickandmortyapp.ui.theme.RickAndMortyAppTheme

@ExperimentalCoilApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyAppTheme {
                MainScreen()
            }
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
        NavigationHostMain(
            navController = navController
        )
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name)) },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.surface
    )
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItemMain.CharactersList,
        NavigationItemMain.LocationsList,
        NavigationItemMain.EpisodesList
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary
    ) {
        val navBackStateEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStateEntry?.destination

        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(item.icon, item.title)
                },
                label = {
                    Text(text = item.title)
                },
                unselectedContentColor = MaterialTheme.colors.surface,
                selectedContentColor = MaterialTheme.colors.secondary,
                alwaysShowLabel = true,
                selected = currentDestination?.hierarchy?.any { navDestination ->
                    navDestination.route == item.route
                } == true,
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
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickAndMortyAppTheme{
        MainScreen()
    }
}

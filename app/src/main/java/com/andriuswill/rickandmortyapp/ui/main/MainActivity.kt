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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andriuswill.rickandmortyapp.ui.component.NavigationItem
import dagger.hilt.android.AndroidEntryPoint
import com.andriuswill.rickandmortyapp.R
import com.andriuswill.rickandmortyapp.ui.characters.CharactersScreen
import com.andriuswill.rickandmortyapp.ui.main.screens.EpisodesScreen
import com.andriuswill.rickandmortyapp.ui.location.LocationsScreen

@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun MainScreen() {
    val viewModel: MainViewModel = hiltViewModel()
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(
            navController = navController
        ) }
    ) {
        Navigation(
            navController = navController,
            viewModel = viewModel
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
        NavigationItem.Characters,
        NavigationItem.Locations,
        NavigationItem.Episodes
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
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                onClick = {
                    navController.navigate(item.route){
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun Navigation(navController: NavHostController, viewModel: MainViewModel){
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Characters.route){
        composable(NavigationItem.Characters.route){
            CharactersScreen(viewModel)
        }
        composable(NavigationItem.Locations.route){
            LocationsScreen(viewModel)
        }
        composable(NavigationItem.Episodes.route){
            EpisodesScreen(viewModel)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    //MainScreen()
}

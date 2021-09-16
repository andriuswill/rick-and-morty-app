package com.andriuswill.rickandmortyapp.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItemMain(
    var route: String,
    var icon: ImageVector,
    var title: String
) {
    object CharactersList : NavigationItemMain(
        "characters_list",
        Icons.Default.Person,
        "Characters"
    )
    object LocationsList : NavigationItemMain(
        "locations_list",
        Icons.Default.Place,
        "Locations"
    )
    object EpisodesList : NavigationItemMain(
        "episodes_list",
        Icons.Default.List,
        "Episodes"
    )
}
package com.andriuswill.rickandmortyapp.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationMainItem(
    var route: String,
    var icon: ImageVector,
    var title: String
) {
    object CharactersList : NavigationMainItem(
        "characters_list",
        Icons.Default.Person,
        "Characters"
    )
    object LocationsList : NavigationMainItem(
        "locations_list",
        Icons.Default.Place,
        "Locations"
    )
    object EpisodesList : NavigationMainItem(
        "episodes_list",
        Icons.Default.List,
        "Episodes"
    )
}
package com.andriuswill.rickandmortyapp.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(
    var route: String,
    var icon: ImageVector,
    var title: String
) {
    object Characters : NavigationItem(
        "characters",
        Icons.Default.Person,
        "Characters"
    )
    object Locations : NavigationItem(
        "locations",
        Icons.Default.Place,
        "Locations"
    )
    object Episodes : NavigationItem(
        "episodes",
        Icons.Default.List,
        "Episodes"
    )
}
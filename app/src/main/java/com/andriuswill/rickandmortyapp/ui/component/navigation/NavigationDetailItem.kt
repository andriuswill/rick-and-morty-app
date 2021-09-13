package com.andriuswill.rickandmortyapp.ui.component.navigation

import com.andriuswill.rickandmortyapp.constants.Constant.ARG_URL

sealed class NavigationDetailItem(
    var route: String
    ) {

    object CharactersDetail : NavigationDetailItem(
        "characters_detail/{$ARG_URL}"
    )
    object LocationDetail : NavigationDetailItem(
        "locations_detail/{$ARG_URL}"
    )
    object EpisodeDetail : NavigationDetailItem(
        "episodes_detail/{$ARG_URL}"
    )
}
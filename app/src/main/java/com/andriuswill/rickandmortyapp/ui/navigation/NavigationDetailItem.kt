package com.andriuswill.rickandmortyapp.ui.navigation

import com.andriuswill.rickandmortyapp.constants.Constant.ARG_CHARACTER_ID
import com.andriuswill.rickandmortyapp.constants.Constant.ARG_EPISODE_ID
import com.andriuswill.rickandmortyapp.constants.Constant.ARG_LOCATION_ID

sealed class NavigationDetailItem(
    var route: String
    ) {
    object CharactersDetail : NavigationDetailItem(
        "characters_detail/{$ARG_CHARACTER_ID}"
    ) {
        fun getWithArg(arg: String) =
            route.replace("{$ARG_CHARACTER_ID}", arg)
    }
    object LocationDetail : NavigationDetailItem(
        "locations_detail/{${ARG_LOCATION_ID}}"
    ){
        fun getWithArg(arg: String) =
            route.replace("{$ARG_LOCATION_ID}", arg)
    }
    object EpisodeDetail : NavigationDetailItem(
        "episodes_detail/{$ARG_EPISODE_ID}"
    ){
        fun getWithArg(arg: String) =
            route.replace("{$ARG_EPISODE_ID}", arg)
    }
}
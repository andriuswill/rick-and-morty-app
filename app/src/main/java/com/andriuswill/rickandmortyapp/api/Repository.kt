package com.andriuswill.rickandmortyapp.api

import com.andriuswill.rickandmortyapp.model.responses.CharactersListResponse
import com.andriuswill.rickandmortyapp.model.responses.EpisodesListResponse
import com.andriuswill.rickandmortyapp.model.responses.LocationsListResponse

interface Repository {

    suspend fun getCharactersList(): CharactersListResponse

    suspend fun getLocationsList(): LocationsListResponse

    suspend fun getEpisodesList(): EpisodesListResponse

}
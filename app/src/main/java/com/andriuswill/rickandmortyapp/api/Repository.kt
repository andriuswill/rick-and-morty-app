package com.andriuswill.rickandmortyapp.api

import com.andriuswill.rickandmortyapp.model.responses.*

interface Repository {

    suspend fun getCharactersList(): CharactersListResponse

    suspend fun getLocationsList(): LocationsListResponse

    suspend fun getEpisodesList(): EpisodesListResponse


    suspend fun getCharacterDetail(characterId: String): CharacterResponse

    suspend fun getLocationDetail(locationId: String): LocationResponse

    suspend fun getEpisodeDetail(episodeId: String): EpisodeResponse


}
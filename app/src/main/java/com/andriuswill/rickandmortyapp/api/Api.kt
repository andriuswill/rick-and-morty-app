package com.andriuswill.rickandmortyapp.api

import com.andriuswill.rickandmortyapp.model.responses.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface Api {

    @GET("character")
    suspend fun getCharactersList(): CharactersListResponse

    @GET("location")
    suspend fun getLocationsList(): LocationsListResponse

    @GET("episode")
    suspend fun getEpisodesList(): EpisodesListResponse


    @GET("character/{id}")
    suspend fun getCharacterDetail(
        @Path("id") characterId: String
    ): CharacterResponse

    @GET("location/{id}")
    suspend fun getLocationDetail(
        @Path("id") locationId: String
    ): LocationResponse

    @GET("episode/{id}")
    suspend fun getEpisodeDetail(
        @Path("id") episodeId: String
    ): EpisodeResponse

}
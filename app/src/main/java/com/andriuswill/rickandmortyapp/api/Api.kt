package com.andriuswill.rickandmortyapp.api

import com.andriuswill.rickandmortyapp.model.responses.CharactersListResponse
import com.andriuswill.rickandmortyapp.model.responses.EpisodesListResponse
import com.andriuswill.rickandmortyapp.model.responses.LocationsListResponse
import retrofit2.http.GET

interface Api {

    @GET("character")
    suspend fun getCharactersList(): CharactersListResponse

    @GET("location")
    suspend fun getLocationsList(): LocationsListResponse

    @GET("episode")
    suspend fun getEpisodesList(): EpisodesListResponse

}
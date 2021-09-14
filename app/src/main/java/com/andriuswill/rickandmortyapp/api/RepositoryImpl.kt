package com.andriuswill.rickandmortyapp.api

import javax.inject.Inject

class RepositoryImpl @Inject constructor (
    private val api: Api
) : Repository {

    override suspend fun getCharactersList() = api.getCharactersList()

    override suspend fun getLocationsList() = api.getLocationsList()

    override suspend fun getEpisodesList() = api.getEpisodesList()


    override suspend fun getCharacterDetail(
        characterId: String
    ) = api.getCharacterDetail(
        characterId = characterId
    )

    override suspend fun getLocationDetail(
        locationId: String
    ) = api.getLocationDetail(
        locationId = locationId
    )

    override suspend fun getEpisodeDetail(
        episodeId: String
    ) = api.getEpisodeDetail(
        episodeId = episodeId
    )
}
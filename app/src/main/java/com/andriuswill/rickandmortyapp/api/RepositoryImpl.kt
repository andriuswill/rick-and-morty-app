package com.andriuswill.rickandmortyapp.api

import javax.inject.Inject

class RepositoryImpl @Inject constructor (
    private val api: Api
) : Repository {

    override suspend fun getCharactersList() = api.getCharactersList()

    override suspend fun getLocationsList() = api.getLocationsList()

    override suspend fun getEpisodesList() = api.getEpisodesList()
}
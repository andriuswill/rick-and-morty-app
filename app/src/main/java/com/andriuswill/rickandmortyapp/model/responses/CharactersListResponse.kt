package com.andriuswill.rickandmortyapp.model.responses

data class CharactersListResponse(
    val infoResponse: InfoResponse,
    val results: List<CharacterResponse>
)
package com.andriuswill.rickandmortyapp.model.responses

data class CharacterResponse(
    val id: Int,
    val name: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: UrlResponse,
    val location: UrlResponse,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)
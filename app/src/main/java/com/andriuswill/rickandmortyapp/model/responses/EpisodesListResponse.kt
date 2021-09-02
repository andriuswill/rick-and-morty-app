package com.andriuswill.rickandmortyapp.model.responses

data class EpisodesListResponse(
    val infoResponse: InfoResponse,
    val results: List<EpisodeResponse>
)
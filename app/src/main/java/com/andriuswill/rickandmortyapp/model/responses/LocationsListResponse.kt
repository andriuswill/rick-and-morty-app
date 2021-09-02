package com.andriuswill.rickandmortyapp.model.responses

data class LocationsListResponse(
    val infoResponse: InfoResponse,
    val results: List<LocationResponse>
)
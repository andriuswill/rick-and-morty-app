package com.andriuswill.rickandmortyapp.model.responses

data class InfoResponse(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)
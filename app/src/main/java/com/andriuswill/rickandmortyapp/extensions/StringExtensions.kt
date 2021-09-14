package com.andriuswill.rickandmortyapp.extensions

fun String.getIdFromUrl() =
    this.split("/").last()
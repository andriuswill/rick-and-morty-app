package com.andriuswill.rickandmortyapp.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andriuswill.rickandmortyapp.api.Repository
import com.andriuswill.rickandmortyapp.model.responses.CharacterResponse
import com.andriuswill.rickandmortyapp.model.responses.EpisodeResponse
import com.andriuswill.rickandmortyapp.model.responses.LocationResponse
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    val loaderCharactersVisible: MutableState<Boolean> = mutableStateOf(false)
    val loaderLocationsVisible: MutableState<Boolean> = mutableStateOf(false)
    val loaderEpisodesVisible: MutableState<Boolean> = mutableStateOf(false)

    val charactersState: MutableState<List<CharacterResponse>> = mutableStateOf(emptyList<CharacterResponse>())
    val locationsState: MutableState<List<LocationResponse>> = mutableStateOf(emptyList<LocationResponse>())
    val episodesState: MutableState<List<EpisodeResponse>> = mutableStateOf(emptyList<EpisodeResponse>())

    fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO){
            charactersState.value = repository.getCharactersList().results
        }
    }

    fun getLocations() {
        viewModelScope.launch(Dispatchers.IO){
            locationsState.value = repository.getLocationsList().results
        }
    }

    fun getEpisodes() {
        viewModelScope.launch(Dispatchers.IO){
            episodesState.value = repository.getEpisodesList().results
        }
    }

}
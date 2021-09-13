package com.andriuswill.rickandmortyapp.ui.main.episodesList

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andriuswill.rickandmortyapp.api.Repository
import com.andriuswill.rickandmortyapp.model.responses.EpisodeResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodesListViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    val loaderEpisodesVisible: MutableState<Boolean> = mutableStateOf(false)

    val episodesState: MutableState<List<EpisodeResponse>> = mutableStateOf(emptyList<EpisodeResponse>())

    fun getEpisodes() {
        viewModelScope.launch(Dispatchers.IO){
            episodesState.value = repository.getEpisodesList().results
        }
    }

}
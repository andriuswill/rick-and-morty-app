package com.andriuswill.rickandmortyapp.ui.detail.episode

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andriuswill.rickandmortyapp.api.Repository
import com.andriuswill.rickandmortyapp.constants.Constant.ARG_EPISODE_ID
import com.andriuswill.rickandmortyapp.model.responses.EpisodeResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeDetailViewModel @Inject constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    val loaderEpisodeDetailVisible: MutableState<Boolean> = mutableStateOf(false)
    val episodeDetailState: MutableState<EpisodeResponse?> = mutableStateOf(null)

    private val currentId = savedStateHandle.get<String>(ARG_EPISODE_ID).orEmpty()

    init {
        getEpisodeDetail()
    }

    private fun getEpisodeDetail() {
        viewModelScope.launch(Dispatchers.IO){
            episodeDetailState.value = repository.getEpisodeDetail(currentId)
        }
    }

}
package com.andriuswill.rickandmortyapp.ui.characters

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andriuswill.rickandmortyapp.api.Repository
import com.andriuswill.rickandmortyapp.model.responses.CharacterResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {


    init {
        viewModelScope.launch(Dispatchers.IO){
            charactersState.value = getCharacters()
            loaderVisible.value = false
        }
    }

    val charactersState: MutableState<List<CharacterResponse>> = mutableStateOf(emptyList<CharacterResponse>())
    val loaderVisible: MutableState<Boolean> = mutableStateOf(true)


    private suspend fun getCharacters() : List<CharacterResponse> {
        return repository.getCharactersList().results
    }



}
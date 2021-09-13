package com.andriuswill.rickandmortyapp.ui.main.charactersList

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
class CharactersListViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    val loaderCharactersVisible: MutableState<Boolean> = mutableStateOf(false)

    val charactersState: MutableState<List<CharacterResponse>> = mutableStateOf(emptyList<CharacterResponse>())

    fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO){
            charactersState.value = repository.getCharactersList().results
        }
    }
}
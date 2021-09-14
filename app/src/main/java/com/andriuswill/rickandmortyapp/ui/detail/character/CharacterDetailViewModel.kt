package com.andriuswill.rickandmortyapp.ui.detail.character

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andriuswill.rickandmortyapp.api.Repository
import com.andriuswill.rickandmortyapp.constants.Constant.ARG_CHARACTER_ID
import com.andriuswill.rickandmortyapp.model.responses.CharacterResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    val loaderCharacterDetailVisible: MutableState<Boolean> = mutableStateOf(false)
    val characterDetailState: MutableState<CharacterResponse?> = mutableStateOf(null)

    private val currentId = savedStateHandle.get<String>(ARG_CHARACTER_ID).orEmpty()

    init {
        getCharacterDetail()
    }

   private fun getCharacterDetail() {
        viewModelScope.launch(Dispatchers.IO){
            characterDetailState.value = repository.getCharacterDetail(currentId)
        }
    }

}
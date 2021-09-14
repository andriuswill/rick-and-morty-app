package com.andriuswill.rickandmortyapp.ui.detail.location

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andriuswill.rickandmortyapp.api.Repository
import com.andriuswill.rickandmortyapp.constants.Constant.ARG_LOCATION_ID
import com.andriuswill.rickandmortyapp.model.responses.LocationResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LocationDetailViewModel@Inject constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    val loaderLocationDetailVisible: MutableState<Boolean> = mutableStateOf(false)
    val locationDetailState: MutableState<LocationResponse?> = mutableStateOf(null)

    private val currentId = savedStateHandle.get<String>(ARG_LOCATION_ID).orEmpty()

    init {
        getLocationDetail()
    }

    private fun getLocationDetail() {
        viewModelScope.launch(Dispatchers.IO){
            locationDetailState.value = repository.getLocationDetail(currentId)
        }
    }

}
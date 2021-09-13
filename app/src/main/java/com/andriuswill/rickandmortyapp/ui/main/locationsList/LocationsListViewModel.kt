package com.andriuswill.rickandmortyapp.ui.main.locationsList

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andriuswill.rickandmortyapp.api.Repository
import com.andriuswill.rickandmortyapp.model.responses.LocationResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationsListViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    val loaderLocationsVisible: MutableState<Boolean> = mutableStateOf(false)

    val locationsState: MutableState<List<LocationResponse>> = mutableStateOf(emptyList<LocationResponse>())

    fun getLocations() {
        viewModelScope.launch(Dispatchers.IO){
            locationsState.value = repository.getLocationsList().results
        }
    }

}
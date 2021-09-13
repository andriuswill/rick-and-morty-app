package com.andriuswill.rickandmortyapp.ui.detail.location

import androidx.lifecycle.ViewModel
import com.andriuswill.rickandmortyapp.api.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class LocationDetailViewModel@Inject constructor(
    private val repository: Repository
): ViewModel() {


}
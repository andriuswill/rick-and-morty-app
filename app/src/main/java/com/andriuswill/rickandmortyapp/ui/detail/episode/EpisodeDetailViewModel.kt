package com.andriuswill.rickandmortyapp.ui.detail.episode

import androidx.lifecycle.ViewModel
import com.andriuswill.rickandmortyapp.api.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeDetailViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {


}
package com.andriuswill.rickandmortyapp.ui.characters

import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CharactersScreen() {
    val viewModel: CharactersViewModel = viewModel()

    val characters = viewModel.charactersState.value
    val loaderVisible = viewModel.loaderVisible.value

    Box(
        contentAlignment = Alignment.Center
    ) {
        Text(text = characters.toString())
        if (loaderVisible) {
            CircularProgressIndicator()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CharactersScreen()

}
package com.andriuswill.rickandmortyapp.ui.characters

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.andriuswill.rickandmortyapp.ui.main.MainViewModel

@Composable
fun CharactersScreen(viewModel: MainViewModel) {

    //val characters = viewModel.charactersState.value

    viewModel.getCharacters()

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Characters")

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    //CharactersScreen()
}
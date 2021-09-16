package com.andriuswill.rickandmortyapp.ui.characters

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.andriuswill.rickandmortyapp.extensions.getIdFromUrl
import com.andriuswill.rickandmortyapp.ui.component.CharacterCard
import com.andriuswill.rickandmortyapp.ui.navigation.NavigationItemDetail
import com.andriuswill.rickandmortyapp.ui.detail.DetailActivity
import com.andriuswill.rickandmortyapp.ui.main.charactersList.CharactersListViewModel

@ExperimentalCoilApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun CharactersListScreen(
    viewModel: CharactersListViewModel
) {

    val characters = viewModel.charactersState.value

    viewModel.getCharacters()


    LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        contentPadding = PaddingValues(4.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(
                bottom = 52.dp
            )
    ) {
        items(characters) { item ->
            CharacterCard(
                characterName = item.name,
                characterImage = item.image,
                characterId = item.url.getIdFromUrl()
            )
        }
    }
}




@ExperimentalCoilApi
@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CharacterCard(
        "name",
        "image",
        "url"
    )
}
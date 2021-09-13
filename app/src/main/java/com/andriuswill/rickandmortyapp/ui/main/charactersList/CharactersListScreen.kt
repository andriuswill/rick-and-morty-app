package com.andriuswill.rickandmortyapp.ui.characters

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.andriuswill.rickandmortyapp.ui.component.navigation.NavigationDetailItem
import com.andriuswill.rickandmortyapp.ui.component.navigation.NavigationMainItem
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

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            contentPadding = PaddingValues(4.dp),
            modifier = Modifier.padding(
                bottom = 52.dp
            )
        ) {
            items(characters) { item ->
                CharacterCard(
                    characterName = item.name,
                    characterImage = item.image,
                    characterUrl = item.url
                )
            }
        }
    }
}


@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun CharacterCard(
    characterName: String,
    characterImage: String,
    characterUrl: String
) {
    val context = LocalContext.current
    Card(
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(
            width = 2.dp,
            color = Color.Black
        ),
        modifier = Modifier
            .padding(4.dp),
        elevation = 2.dp,
        onClick = {
            DetailActivity.start(
                context,
                NavigationDetailItem.CharactersDetail.route,
                characterUrl
            )
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberImagePainter(
                    data = characterImage
                ),
                contentDescription = characterName,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(128.dp)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(
                    text = characterName,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

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
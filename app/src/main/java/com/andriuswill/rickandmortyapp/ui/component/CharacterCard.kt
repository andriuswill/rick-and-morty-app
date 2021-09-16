package com.andriuswill.rickandmortyapp.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.andriuswill.rickandmortyapp.ui.detail.DetailActivity
import com.andriuswill.rickandmortyapp.ui.navigation.NavigationItemDetail

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun CharacterCard(
    characterName: String,
    characterImage: String,
    characterId: String
) {
    val context = LocalContext.current
    Card(
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(
            width = 2.dp,
            color = Color.Black
        ),

        modifier = Modifier
            .aspectRatio(0.75F)
            .padding(4.dp),
        elevation = 2.dp,
        onClick = {
            DetailActivity.start(
                context,
                NavigationItemDetail.CharactersDetail.route,
                characterId
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
                    .weight(1F)
            )
            Box(
                contentAlignment = Alignment.Center,

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                Text(
                    text = characterName,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
        }
    }
}
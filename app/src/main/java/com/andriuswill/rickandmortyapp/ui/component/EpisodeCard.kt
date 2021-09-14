package com.andriuswill.rickandmortyapp.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@ExperimentalMaterialApi
@Composable
fun EpisodeCard(
    episodeName: String,
    episodeInfo: String,
    clickAction: () -> Unit
) {
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
            clickAction.invoke()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = episodeInfo,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = episodeName,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
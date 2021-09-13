package com.andriuswill.rickandmortyapp.ui.location

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andriuswill.rickandmortyapp.ui.component.navigation.NavigationDetailItem
import com.andriuswill.rickandmortyapp.ui.component.navigation.NavigationMainItem
import com.andriuswill.rickandmortyapp.ui.detail.DetailActivity
import com.andriuswill.rickandmortyapp.ui.main.locationsList.LocationsListViewModel

@ExperimentalMaterialApi
@Composable
fun LocationsListScreen(
    viewModel: LocationsListViewModel
) {

    val locations = viewModel.locationsState.value

    viewModel.getLocations()

    LazyColumn(
        contentPadding = PaddingValues(4.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(locations) { item ->
            LocationCard(
                locationName = item.name,
                locationUrl = item.url
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun LocationCard(
    locationName: String,
    locationUrl: String
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
                NavigationDetailItem.LocationDetail.route,
                locationUrl
            )
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                text = locationName,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    //LocationsScreen()
}
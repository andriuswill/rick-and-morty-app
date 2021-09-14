package com.andriuswill.rickandmortyapp.ui.detail.location

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.andriuswill.rickandmortyapp.extensions.getIdFromUrl
import com.andriuswill.rickandmortyapp.ui.component.LocationCard
import com.andriuswill.rickandmortyapp.ui.navigation.NavigationDetailItem


@ExperimentalMaterialApi
@Composable
fun LocationDetailScreen(
    viewModel: LocationDetailViewModel,
    navController: NavHostController
) {

    val locationDetail = viewModel.locationDetailState.value

    LazyColumn(
        contentPadding = PaddingValues(4.dp),
        modifier = Modifier.fillMaxSize()
    ) {

        items(locationDetail?.residents.orEmpty()) { url ->
            LocationCard(
                locationName = url
            ) {
                navController.navigate(
                    route = NavigationDetailItem
                        .CharactersDetail
                        .getWithArg(url.getIdFromUrl()),
                )
            }
        }
    }

}
package com.andriuswill.rickandmortyapp.ui.location

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
fun LocationsScreen(viewModel: MainViewModel) {

    val locations = viewModel.locationsState.value

    viewModel.getLocations()

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Locations")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    //LocationsScreen()
}
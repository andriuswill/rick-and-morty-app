package com.andriuswill.rickandmortyapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.andriuswill.rickandmortyapp.ui.characters.CharactersScreen
import com.andriuswill.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colors.background) {
                CharactersScreen()
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CharactersScreen()

}
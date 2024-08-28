package com.example.getapijetpackcomposeretrofithilt.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.getapijetpackcomposeretrofithilt.model.Result

@Composable
fun CharactersScreen(
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    Log.d("Quantity of images: ", "${state.size}")
    LazyColumn {
        items(state) { result ->
            CharacterCard(result)

        }
    }
}

@Composable
fun CharacterCard(
    result: Result,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Column {
            Row {
                Surface(
                    modifier.size(120.dp),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
                ) {
                    AsyncImage(
                        model = result.image,
                        contentDescription = result.name,
                        contentScale = ContentScale.FillBounds
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .align(Alignment.CenterVertically)
                        .weight(1f)
                ) {
                    Text(
                        text = result.name,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }
    }
}

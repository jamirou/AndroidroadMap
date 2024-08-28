package com.example.getapijetpackcomposeretrofithilt.screens

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
    var expandedIcon by remember { mutableStateOf(false) }
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
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
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val color = when (result.status) {
                            "Alive" -> Color.Green
                            "Dead" -> Color.Red
                            else -> Color.Gray
                        }
                        Box(
                            modifier
                                .padding(2.dp)
                                .clip(CircleShape)
                                .background(color)
                                .size(12.dp)
                        )
                        Text(
                            text = "${result.status} - ${result.species}",
                            style = MaterialTheme.typography.titleSmall,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }
                IconButton(onClick = {
                    expandedIcon = !expandedIcon
                }) {
                    modifier.align(Alignment.CenterVertically)
                    Icon(
                        imageVector =
                        if (expandedIcon) Icons.Filled.ExpandLess
                        else Icons.Filled.ExpandMore,
                        contentDescription = "Show more",
                    )
                }
            }
            if (expandedIcon) {
                Row(
                    modifier.padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = "Last view",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = result.location.name,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}

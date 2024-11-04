package com.example.firebasepractice.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.firebasepractice.R
import com.example.firebasepractice.presentation.model.Artist
import com.example.firebasepractice.presentation.model.Player
import com.example.firebasepractice.ui.theme.Black
import com.example.firebasepractice.ui.theme.Purple80


/*@Preview*/
@Composable
fun HomeScreen(viewModel: HomeViewModel = HomeViewModel()) {

    val artists = viewModel.artists.collectAsState()
    val player by viewModel.player.collectAsState()

    Column(
        Modifier
            .fillMaxSize()
            .background(Black)
    ) {
        Text(
            "Popular artists",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(16.dp)
        )

        LazyRow {
            items(artists.value) {
                ArtistItem(it)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        player?.let {
            PlayerComponent(player = it, onPlaySelected = {viewModel.onPlaySelected()}, onCancelSelected = {viewModel.onCancelSelected()})
        }

    }
}

@Composable
fun PlayerComponent(
    player: Player,
    onPlaySelected: () -> Unit,
    onCancelSelected: () -> Unit,
) {
    val icon = if (player.play == true) R.drawable.ic_pause else R.drawable.ic_play
    Row(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(Purple80),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = player.artist?.name.orEmpty(),
            modifier = Modifier.padding(horizontal = 12.dp),
            color = Color.White
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(painter = painterResource(icon),
            contentDescription = "play/pause",
            modifier = Modifier
                .size(40.dp)
                .clickable { onPlaySelected() })
        Image(painter = painterResource(R.drawable.ic_clear),
            contentDescription = "Close",
            modifier = Modifier
                .size(40.dp)
                .clickable { onCancelSelected() })

    }
}

@Composable
fun ArtistItem(artis: Artist) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            model = artis.image,
            contentDescription = "Artist image",
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = artis.name.orEmpty(), color = Color.White)
    }
}

@Preview
@Composable
fun PreviewArtistItem() {
    val artist = Artist(
        "Artist 1",
        "Description 1",
        "https://laverdadnoticias.com/img/2020/02/09/2_viral_inapropiadas_fotos_de_un_gato_comiendo_plxtano_causas_furor_en_internet.jpg?__scale=c:transparent,w:480,h:480,t:3",
        /*emptyList()*/
    )
    ArtistItem(artist)
}




















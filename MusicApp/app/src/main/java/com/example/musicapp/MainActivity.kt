package com.example.musicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.musicapp.data.model.Album
import com.example.musicapp.data.remote.ApiClient
import com.example.musicapp.repository.AlbumRepository
import com.example.musicapp.ui.theme.MusicAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            MusicAppTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val apiService = ApiClient.build()
    val repository = AlbumRepository(apiService)
    var albums: List<Album> by remember{ mutableStateOf(listOf()) }

    LaunchedEffect(key1 = Unit, block = {
        albums = repository.fetchAlbums().body()!!.loved
    } )


    Scaffold {
        AlbumList(albums)
    }
}

@Composable
fun AlbumList(albums: List<Album> = listOf()) {
    LazyColumn{
        items(albums) { album ->
            AlbumRow(album)
        }
    }
}

@Composable
fun AlbumRow(album: Album) {
    Row {
       AlbumImage(album)
        Column {
            Text(album.name)
            Text(album.artist)
        }
        IconButton(onClick = { }) {
            Icon(Icons.Filled.Favorite,null)
        }
    }
}

@Composable
fun AlbumImage(album: Album) {
    Image(
        painter = rememberImagePainter(album.imageAlbum),
        contentDescription = null,
        modifier = Modifier.size(128.dp)
    )
}

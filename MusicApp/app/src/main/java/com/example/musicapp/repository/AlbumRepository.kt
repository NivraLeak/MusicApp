package com.example.musicapp.repository

import com.example.musicapp.data.remote.ApiService

class AlbumRepository(private val apiService: ApiService) {
    suspend fun fetchAlbumsByArtist(name: String = "coldplay") = apiService.fetchAlbumByArtist(name)
    suspend fun fetchAlbums() = apiService.fetchAlbums()

}
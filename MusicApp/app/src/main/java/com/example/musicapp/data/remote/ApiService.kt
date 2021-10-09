package com.example.musicapp.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("search.php?s={name}")
    suspend fun fetchAlbumByArtist(@Path("name") name: String = "Bad"): Response<ApiResponse>

    @GET("mostloved.php?format=album")
    suspend fun fetchAlbums():Response<ApiResponse>
}
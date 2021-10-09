package com.example.musicapp.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "heroes")
class Album (
    @PrimaryKey
    @SerializedName("idAlbum")
    val id: String,

    @SerializedName("strAlbum")
    @ColumnInfo(name = "album_name")
    val name: String,

    @SerializedName("strAlbumThumb")
    @ColumnInfo(name = "album_image")
    var imageAlbum: String,

    @SerializedName("strArtist")
    @ColumnInfo(name = "artista")
    var artist: String ) {
}
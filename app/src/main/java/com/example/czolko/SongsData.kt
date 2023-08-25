package com.example.czolko
import kotlinx.serialization.Serializable

@Serializable
data class SongsData (var songs: MutableList<Song>){
}
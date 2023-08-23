package com.example.czolko
import kotlinx.serialization.Serializable

@Serializable
data class SongsData (var songsList: MutableList<Song>){
//    val songs = mutableListOf<String>()

}
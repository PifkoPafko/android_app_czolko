package com.example.czolko

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.czolko.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val jsonFileString = Utils.getJsonDataFromAsset(applicationContext, "songs_data.json")!!
        val gson = Gson()
        val listPersonType = object : TypeToken<SongsData>() {}.type
        var songsList: SongsData = gson.fromJson(jsonFileString, listPersonType)

        SongsParsed.setSongs(songsList)
    }
}

object SongsParsed {
    private var songs: SongsData = SongsData(mutableListOf())

    fun setSongs (songsList: SongsData) {
        songs = songsList
    }

    fun getSongs () : SongsData {
        return songs
    }
}
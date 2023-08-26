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

        val songsJsonString = Utils.getJsonDataFromAsset(applicationContext, "songs_data.json")!!
        val songsGson = Gson()
        val songsType = object : TypeToken<SongsData>() {}.type
        var songsData: SongsData = songsGson.fromJson(songsJsonString, songsType)
        SongsParsed.setSongs(songsData)

        val settingsJsonString = Utils.getJsonDataFromAsset(applicationContext, "settings_data.json")!!
        val settingsGson = Gson()
        val settingsType = object : TypeToken<SettingsData>() {}.type
        var settingsData: SettingsData = settingsGson.fromJson(settingsJsonString, settingsType)
        SettingsParsed.setSettings(settingsData)
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

object SettingsParsed {
    private var settings: SettingsData = SettingsData(0, 0)

    fun setSettings (dataSettings: SettingsData) {
        settings.roundTime = dataSettings.roundTime
        settings.roundAmount = dataSettings.roundAmount
    }

    fun getSettings () : SettingsData {
        return settings
    }
}
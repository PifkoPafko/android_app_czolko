package com.example.czolko

import kotlinx.serialization.Serializable

@Serializable
data class SettingsData (var roundTime : Long, var roundAmount : Int){
}
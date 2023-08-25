package com.example.czolko

import kotlinx.serialization.Serializable

@Serializable
data class Song (val isSanah: Boolean, val isOtherShit: Boolean, val title: String){
}
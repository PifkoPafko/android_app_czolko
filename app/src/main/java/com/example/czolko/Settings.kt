package com.example.czolko

class Settings {
    private var roundTime = 30
    private var roundAmount = 10
    private var disableSanah = true
    private var disableOtherShit = true

    fun getRoundTime(): Int {
        return roundTime
    }

    fun setRoundTime(newRoundTime: Int) {
        roundTime = newRoundTime
    }

    fun getRoundAmount(): Int {
        return roundAmount
    }

    fun setRoundAmount(newRoundAmount: Int) {
        roundAmount = newRoundAmount
    }

    fun getDisableSanah(): Boolean {
        return disableSanah
    }

    fun setDisableSanah(newDisableSanah: Boolean) {
        disableSanah = newDisableSanah
    }

    fun getDisableOtherShit(): Boolean {
        return disableOtherShit
    }

    fun setDisableOtherShit(newDisableOtherShit: Boolean) {
        disableOtherShit = newDisableOtherShit
    }
}
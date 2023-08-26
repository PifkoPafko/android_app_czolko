package com.example.czolko

import android.os.CountDownTimer
import android.view.View
import com.example.czolko.databinding.FragmentPlayBinding

class Game (val binding : PlayFragment.PlayBindings, settings : SettingsParsed) {
    private val settings : SettingsParsed
    private val roundTimer : CountDownTimer
    private val prepareTimer : CountDownTimer
    private var isGoing : Boolean = false
    private var round : Int = 0
    init {
        this.settings = settings
        roundTimer = object : CountDownTimer(settings.getSettings().roundTime, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val tickString = (millisUntilFinished / 1000 + 1).toString()
                binding.timerText.text = tickString
            }

            override fun onFinish() {
                binding.buttonGoodAnswer.visibility = View.GONE
                binding.buttonBadAnswer.visibility = View.GONE
                binding.viewSeparateLine.visibility = View.GONE
                binding.textTitle.visibility = View.GONE
                binding.textTitle.text = SongsParsed.getSongs().songs[round].title
                binding.timerText.visibility = View.GONE

                binding.buttonNext.visibility = View.VISIBLE
            }
        }

        prepareTimer = object: CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val tickString = (millisUntilFinished / 1000 + 1).toString()
                binding.timerText.text = tickString
            }

            override fun onFinish() {
                nextRound(true)
            }
        }
    }

    fun startGame () {
        prepareTimer.start()
    }

    fun nextRound (isGoodAnswer : Boolean) {
        if (round < settings.getSettings().roundAmount)
        {
            binding.buttonGoodAnswer.visibility = View.VISIBLE
            binding.buttonBadAnswer.visibility = View.VISIBLE
            binding.viewSeparateLine.visibility = View.VISIBLE
            binding.buttonNext.visibility = View.GONE
            binding.textTitle.visibility = View.VISIBLE
            binding.textTitle.text = SongsParsed.getSongs().songs[round].title
            binding.timerText.visibility = View.VISIBLE
            binding.timerText.text = ""
            roundTimer.start()
        } else {
            endGame()
        }
        round++
    }

    private fun endGame () {
        binding.buttonGoodAnswer.visibility = View.GONE
        binding.buttonBadAnswer.visibility = View.GONE
        binding.buttonNext.visibility = View.GONE
        binding.viewSeparateLine.visibility = View.GONE
        binding.textTitle.visibility = View.VISIBLE
        binding.textTitle.text = "Koniec"
        binding.timerText.visibility = View.GONE

        binding.buttonGoBack.visibility = View.VISIBLE
    }
}
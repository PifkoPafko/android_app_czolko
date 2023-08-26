package com.example.czolko

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.czolko.databinding.FragmentPlayBinding
import com.google.android.material.textview.MaterialTextView

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class PlayFragment : Fragment() {

    private var _binding: FragmentPlayBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    inner class PlayBindings {
        val buttonGoBack = binding.buttonGoBack
        val buttonNext = binding.buttonNext
        val buttonGoodAnswer = binding.buttonGoodAnswer
        val buttonBadAnswer = binding.buttonBadAnswer
        val timerText = binding.timerText
        val viewSeparateLine = binding.viewSeparateLine
        val textTitle = binding.textTitle
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        _binding = FragmentPlayBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val playBindings = PlayBindings()
        val game = Game(playBindings, SettingsParsed)

        playBindings.buttonGoBack.setOnClickListener {
            findNavController().navigate(R.id.action_PlayFragment_to_MenuFragment)
        }

        playBindings.buttonGoodAnswer.setOnClickListener {
            game.nextRound(true)
        }

        playBindings.buttonBadAnswer.setOnClickListener {
            game.nextRound(false)
        }

        playBindings.buttonNext.setOnClickListener {
            game.nextRound(false)
        }

        game.startGame()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
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

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class PlayFragment : Fragment() {

    private var _binding: FragmentPlayBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;


        _binding = FragmentPlayBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonGoBack.setOnClickListener {
            findNavController().navigate(R.id.action_PlayFragment_to_MenuFragment)
        }

        val timerText = binding.timerText
        val buttonGoBack = binding.buttonGoBack
        val buttonNext = binding.buttonNext
        val buttonGoodAnswer = binding.buttonGoodAnswer
        val buttonBadAnswer = binding.buttonBadAnswer
        val viewSeparateLine = binding.viewSeparateLine

        val roundTimer = object: CountDownTimer(30000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                timerText.text = (millisUntilFinished/1000).toString()
            }

            override fun onFinish() {
                timerText.text = ""
                buttonNext.visibility = View.VISIBLE
            }
        }

        val startTimer = object: CountDownTimer(5000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                timerText.text = (millisUntilFinished/1000).toString()
            }

            override fun onFinish() {
                roundTimer.start()
                buttonGoodAnswer.visibility = View.VISIBLE
                buttonBadAnswer.visibility = View.VISIBLE
                viewSeparateLine.visibility = View.VISIBLE
            }
        }

        startTimer.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.mindmend_mobileappformentalhealth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TextView


class TodayFragment : Fragment() {

    private lateinit var recommendationText: TextView
    private lateinit var challengesText: TextView
    private lateinit var exercisesText: TextView
    private lateinit var moodSpinner: Spinner

    // Mood-specific content
    private val moodData = mapOf(
        "Happy" to Triple("Keep spreading joy!", "Give 3 compliments today", "Gratitude journaling for 5 min"),
        "Sad" to Triple("It’s okay to feel this way.", "Talk to a friend", "Do a 5 min breathing exercise"),
        "Anxious" to Triple("You're stronger than you think.", "Limit social media for 1 hour", "10 min mindfulness meditation"),
        "Angry" to Triple("Take a deep breath.", "Write down what's bothering you", "Go for a brisk walk or stretch")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_today, container, false)

        // Bind views
        recommendationText = view.findViewById(R.id.recommendation_text)
        challengesText = view.findViewById(R.id.challenges_text)
        exercisesText = view.findViewById(R.id.exercises_text)
        moodSpinner = view.findViewById(R.id.mood_spinner)

        // Spinner Listener
        moodSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
                val selectedMood = parent?.getItemAtPosition(position).toString()
                updateMoodContent(selectedMood)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Optional: handle no mood selected
            }
        }

        return view
    }

    private fun updateMoodContent(mood: String) {
        moodData[mood]?.let {
            recommendationText.text = it.first
            challengesText.text = it.second
            exercisesText.text = it.third
        } ?: run {
            recommendationText.text = "Select a mood to get started."
            challengesText.text = ""
            exercisesText.text = ""
        }
    }
}

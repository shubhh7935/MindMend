package com.example.mindmend_mobileappformentalhealth

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SurveyActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var submitButton: Button
    private lateinit var adapter: SurveyAdapter
    private var questions = SurveyRepository.getSurveyQuestions()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)

        recyclerView = findViewById(R.id.surveyRecyclerView)
        submitButton = findViewById(R.id.submitButton)

        // Load previous answers from SharedPreferences
        loadAnswers()

        // Set up RecyclerView
        adapter = SurveyAdapter(questions) { questionId, answer ->
            saveAnswer(questionId, answer)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Handle submit button click
        submitButton.setOnClickListener {
            Toast.makeText(this, "Survey submitted successfully!", Toast.LENGTH_SHORT).show()

            // Navigate to HomeActivity
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Close SurveyActivity after submission
        }

    }

    private fun saveAnswer(questionId: Int, answer: String) {
        val sharedPreferences = getSharedPreferences("SurveyResponses", Context.MODE_PRIVATE)
        sharedPreferences.edit()
            .putString("question_$questionId", answer)
            .apply()
    }

    private fun loadAnswers() {
        val sharedPreferences = getSharedPreferences("SurveyResponses", Context.MODE_PRIVATE)
        questions.forEach { question ->
            question.userAnswer = sharedPreferences.getString("question_${question.id}", null)
        }
    }
}
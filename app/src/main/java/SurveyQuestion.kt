package com.example.mindmend_mobileappformentalhealth

data class SurveyQuestion(
    val id: Int,                   // Unique ID for each question
    val questionText: String,      // Question text
    val options: List<String>,     // List of answer options
    var userAnswer: String? = null // Store user's answer
)
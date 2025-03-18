package com.example.mindmend_mobileappformentalhealth

object SurveyRepository {

    fun getSurveyQuestions(): List<SurveyQuestion> {
        return listOf(
            SurveyQuestion(
                id = 1,
                questionText = "How often do you feel anxious or worried in a typical week?",
                options = listOf("Never", "Rarely", "Sometimes", "Often", "Almost always")
            ),
            SurveyQuestion(
                id = 2,
                questionText = "How would you rate your current stress level?",
                options = listOf("1", "2", "3", "4", "5")
            ),
            SurveyQuestion(
                id = 3,
                questionText = "Do you have trouble sleeping due to overthinking or anxiety?",
                options = listOf("Yes", "No", "Sometimes")
            ),
            SurveyQuestion(
                id = 4,
                questionText = "How often do you experience physical symptoms of anxiety (e.g., heart racing, sweating, difficulty breathing)?",
                options = listOf("Never", "Rarely", "Sometimes", "Often", "Always")
            ),
            SurveyQuestion(
                id = 5,
                questionText = "Do you feel comfortable talking to others about your mental health?",
                options = listOf("Yes", "No", "It depends on the person")
            ),
            SurveyQuestion(
                id = 6,
                questionText = "How frequently do you experience feelings of sadness or hopelessness?",
                options = listOf("Never", "Rarely", "Sometimes", "Often", "Always")
            ),
            SurveyQuestion(
                id = 7,
                questionText = "Do you have a preferred coping mechanism for stress or anxiety?",
                options = listOf(
                    "Breathing exercises",
                    "Meditation",
                    "Talking to someone",
                    "Physical activity",
                    "None"
                )
            ),
            SurveyQuestion(
                id = 8,
                questionText = "Have you ever experienced a panic attack?",
                options = listOf("Yes", "No", "Not sure")
            ),
            SurveyQuestion(
                id = 9,
                questionText = "When feeling stressed or anxious, do you find it difficult to focus or complete tasks?",
                options = listOf("Yes", "No", "Sometimes")
            ),
            SurveyQuestion(
                id = 10,
                questionText = "What kind of support would you find most helpful?",
                options = listOf(
                    "Breathing exercises",
                    "Relaxation techniques",
                    "Counseling resources",
                    "Self-help articles",
                    "Peer support"
                )
            )
        )
    }
}
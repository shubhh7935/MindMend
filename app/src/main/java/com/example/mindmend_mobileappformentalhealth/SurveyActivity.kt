package com.example.mindmend_mobileappformentalhealth

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.mindmend_mobileappformentalhealth.R

class SurveyActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var surveyAdapter: SurveyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)

        viewPager = findViewById(R.id.viewPager)
        surveyAdapter = SurveyAdapter(getQuestions())
        viewPager.adapter = surveyAdapter

        findViewById<Button>(R.id.btnPrevious).setOnClickListener {
            if (viewPager.currentItem > 0) {
                viewPager.currentItem = viewPager.currentItem - 1
            }
        }

        findViewById<Button>(R.id.btnNext).setOnClickListener {
            if (viewPager.currentItem < surveyAdapter.itemCount - 1) {
                viewPager.currentItem = viewPager.currentItem + 1
            }
        }
    }

    private fun getQuestions(): List<Question> {
        return listOf(
            Question("What are your main goals?", listOf("Support mental health", "Reduce stress", "Find new practices", "Improve sleep")),
            Question("How often in the past two weeks have you felt tired?", listOf("Never", "Several times", "More than half the days", "Nearly every day")),
            Question("Have you ever had panic attacks?", listOf("Yes", "No", "Not sure")),
            Question("What do you want to see more often?", listOf("Physical practices", "Coping cards", "Breathing practices", "Articles"))
        )
    }
}
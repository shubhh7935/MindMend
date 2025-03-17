package com.example.mindmend_mobileappformentalhealth

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.*
class SurveyActivity : AppCompatActivity() {
    private lateinit var etFeeling: EditText
    private lateinit var rgPanic: RadioGroup
    private lateinit var cbAnxiety: CheckBox
    private lateinit var cbDepression: CheckBox
    private lateinit var cbSleepIssues: CheckBox
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey)
        enableEdgeToEdge()

        etFeeling = findViewById(R.id.etFeeling)
        rgPanic = findViewById(R.id.rgPanic)
        cbAnxiety = findViewById(R.id.cbAnxiety)
        cbDepression = findViewById(R.id.cbDepression)
        cbSleepIssues = findViewById(R.id.cbSleepIssues)
        btnSubmit = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            submitSurvey()
        }
    }

    private fun submitSurvey() {
        val feeling = etFeeling.text.toString()
        val panic = when (rgPanic.checkedRadioButtonId) {
            R.id.rbYes -> "Yes"
            R.id.rbNo -> "No"
            else -> ""
        }
        //get checkbox values
        val symptoms = mutableListOf<String>()
        if (cbAnxiety.isChecked) symptoms.add("Anxiety")
        if (cbDepression.isChecked) symptoms.add("Depression")
        if (cbSleepIssues.isChecked) symptoms.add("Sleep Issues")

        //validation
        if (feeling.isEmpty() || panic.isEmpty()) {
            Toast.makeText(this, "Please enter your feeling", Toast.LENGTH_SHORT).show()
            return
        }

        //save data
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("FEELING", feeling)
            putExtra("PANIC", panic)
            putExtra("SYMPTOMS", symptoms.joinToString(", "))
        }
        startActivity(intent)
    }
}
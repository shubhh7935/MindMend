package com.example.mindmend_mobileappformentalhealth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SurveyAdapter(
    private val questions: List<SurveyQuestion>,
    private val onAnswerSelected: (questionId: Int, answer: String) -> Unit
) : RecyclerView.Adapter<SurveyAdapter.SurveyViewHolder>() {

    inner class SurveyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questionText: TextView = itemView.findViewById(R.id.questionText)
        val radioGroup: RadioGroup = itemView.findViewById(R.id.optionsRadioGroup)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurveyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_survey_question, parent, false)
        return SurveyViewHolder(view)
    }

    override fun onBindViewHolder(holder: SurveyViewHolder, position: Int) {
        val question = questions[position]

        holder.questionText.text = question.questionText
        holder.radioGroup.removeAllViews()

        // Create radio buttons for each option
        question.options.forEach { option ->
            val radioButton = RadioButton(holder.itemView.context)
            radioButton.text = option
            radioButton.id = View.generateViewId()

            // Set checked state if user has already answered
            if (question.userAnswer == option) {
                radioButton.isChecked = true
            }

            // Handle answer selection
            radioButton.setOnClickListener {
                onAnswerSelected(question.id, option)
            }

            holder.radioGroup.addView(radioButton)
        }
    }

    override fun getItemCount() = questions.size
}

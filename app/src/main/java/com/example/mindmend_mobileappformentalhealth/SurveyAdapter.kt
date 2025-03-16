package com.example.mindmend_mobileappformentalhealth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mindmend_mobileappformentalhealth.R

class SurveyAdapter(private val questions: List<Question>) : RecyclerView.Adapter<SurveyAdapter.SurveyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurveyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        return SurveyViewHolder(view)
    }

    override fun onBindViewHolder(holder: SurveyViewHolder, position: Int) {
        holder.bind(questions[position])
    }

    override fun getItemCount(): Int = questions.size

    class SurveyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val questionText: TextView = itemView.findViewById(R.id.questionText)
        private val optionsText: TextView = itemView.findViewById(R.id.optionsText)

        fun bind(question: Question) {
            questionText.text = question.text
            optionsText.text = question.options.joinToString("\n")
        }
    }
}
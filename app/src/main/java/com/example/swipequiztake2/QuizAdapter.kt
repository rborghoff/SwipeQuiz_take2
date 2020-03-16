package com.example.swipequiz
import android.view.LayoutInflater
import android.view.ViewGroup

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.swipequiztake2.R
import kotlinx.android.synthetic.main.quiz_content.view.*


class QuizAdapter (private val questions: List<Question>):
    RecyclerView.Adapter<QuizAdapter.Viewholder>() {

    override fun getItemCount(): Int {
        return questions.size;
    }

    override fun onBindViewHolder(holder: QuizAdapter.Viewholder, position: Int) {
        holder.bind((questions[position]))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizAdapter.Viewholder {
        return Viewholder(
            LayoutInflater.from(parent.context).inflate(R.layout.quiz_content,parent,false)
        )
    }

    inner class Viewholder(itemView:View) :
        RecyclerView.ViewHolder(itemView){

        fun bind(question: Question){
            itemView.tvQuiz.text = question.question

        }
    }
}
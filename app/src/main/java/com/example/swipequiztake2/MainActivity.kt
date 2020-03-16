package com.example.swipequiztake2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swipequiz.Question
import com.example.swipequiz.QuizAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val quizzes = arrayListOf<Question>()
    private val quizadapter = QuizAdapter(quizzes)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

private fun initView(){
    rvMain.layoutManager = LinearLayoutManager(this@MainActivity,RecyclerView.VERTICAL,false)
    rvMain.adapter = quizadapter
    for (i in Question.QUESTION_LIST.indices){
        quizzes.add(Question(Question.QUESTION_LIST[i],Question.QUESTION_ANSWER[i]))
    }
    quizadapter.notifyDataSetChanged()
    createItemTouchhelper().attachToRecyclerView(rvMain)
}

    private fun correctAnswer(){
        return Snackbar.make(rvMain,"Het antwoord is correct.",Snackbar.LENGTH_SHORT).show()
    }
    private fun inCorrectAnswer(){
        return Snackbar.make(rvMain,"Helaas dit antwoord was fout.",Snackbar.LENGTH_SHORT).show()
    }
    private fun createItemTouchhelper(): ItemTouchHelper {
        val callback = object  : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT.or(ItemTouchHelper.LEFT)){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder

            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                quizadapter.notifyDataSetChanged()
                val answers = quizzes[position].answer

                if ((direction == ItemTouchHelper.RIGHT && answers) || (direction == ItemTouchHelper.LEFT && !answers)) {
                    quizzes.removeAt(position)
                    return correctAnswer()
                }else{return inCorrectAnswer()
                }
                quizadapter.notifyItemChanged(viewHolder.adapterPosition)
            }
        }
        return ItemTouchHelper(callback)
    }

}

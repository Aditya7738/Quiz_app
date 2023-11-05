package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.databinding.ActivityQuestionsBinding


class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityQuestionsBinding

    var questionList: ArrayList<Questions>? = null

    var selectedOption: Int = 0

    var currentPosition: Int = 0

    var correctAnswers: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questionList = Constants.getQuestions()

        setQuestion()

        binding.optionOne.setOnClickListener(this)
        binding.optionTwo.setOnClickListener(this)
        binding.optionThree.setOnClickListener(this)
        binding.optionFour.setOnClickListener(this)

        binding.submitBtn.setOnClickListener(this)
    }

    fun setQuestion() {

        val questions = questionList!![currentPosition]

        defaultOptionsView()

        if(currentPosition == questionList!!.size-1){
            binding.submitBtn.text = "FINISH"
        }else{
            binding.submitBtn.text = "SUBMIT"
        }



        binding.questionProgress.progress = currentPosition + 1

        binding.textProgress.text =
            (currentPosition + 1).toString() + "/" + binding.questionProgress.max


        binding.question.text = questions.question
        binding.questionImage.setImageResource(questions.image)
        binding.optionOne.text = questions.optionOne
        binding.optionTwo.text = questions.optionTwo
        binding.optionThree.text = questions.optionThree
        binding.optionFour.text = questions.optionFour


    }

    fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, binding.optionOne)
        options.add(1, binding.optionTwo)
        options.add(2, binding.optionThree)
        options.add(3, binding.optionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))

            option.typeface = Typeface.DEFAULT

            option.background = ContextCompat.getDrawable(this, R.drawable.options_border)
        }

    }

    override fun onClick(view: View?) {
        val id = view?.id
        when (view?.id) {
            R.id.option_one -> {
                selectedOptionView(binding.optionOne, 1)
            }

            R.id.option_two -> {
                selectedOptionView(binding.optionTwo, 2)
            }

            R.id.option_three -> {
                selectedOptionView(binding.optionThree, 3)
            }

            R.id.option_four -> {
                selectedOptionView(binding.optionFour, 4)
            }

            R.id.submit_btn -> {
                if (selectedOption == 0) {
                    currentPosition++

                    when {
                        currentPosition <= questionList!!.size-1 -> {
                            setQuestion()
                        }

                        else -> {
                            Toast.makeText(this, "You have reach end of Quiz", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                }else{
                    val question = questionList?.get(currentPosition)

                    if (question != null) {
                        answerView(question.correctAnswer, R.drawable.correct_options_border_bg)
                    }
                    
                    if(question?.correctAnswer != selectedOption){
                        answerView(selectedOption, R.drawable.incorrect_options_border_bg)
                    }else{
                        correctAnswers++
                    }
                    
                    if(currentPosition == questionList!!.size-1){
                        binding.submitBtn.text = "FINISH"

                        startActivity(
                            Intent(this, ResultActivity::class.java)
                            .putExtra(Constants.USER_NAME, intent.getStringExtra(Constants.USER_NAME))
                                .putExtra(Constants.CORRECT_ANSWERS, correctAnswers)
                                .putExtra(Constants.TOTAL_QUESTIONS, questionList!!.size)
                        )

                    }else{
                        binding.submitBtn.text = "GO TO NEXT QUESTION"
                    }
                    
                    selectedOption = 0
                    
                    
                }


            }
        }
    }

    fun selectedOptionView(textView: TextView, selectedOptionNumber: Int) {
        defaultOptionsView()
        selectedOption = selectedOptionNumber

        textView.setTextColor(Color.parseColor("#363A43"))

        textView.setTypeface(textView.typeface, Typeface.BOLD)

        textView.background = ContextCompat.getDrawable(this, R.drawable.selected_options_border)
    }

    fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                binding.optionOne.background = ContextCompat.getDrawable(this, drawableView)
            }

            2 -> {
                binding.optionTwo.background = ContextCompat.getDrawable(this, drawableView)
            }

            3 -> {
                binding.optionThree.background = ContextCompat.getDrawable(this, drawableView)
            }

            4 -> {
                binding.optionFour.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }
}
package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.username.text = intent.getStringExtra(Constants.USER_NAME)

        val score = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val questions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)

        binding.scoreTxt.text = "Your score is $score out of $questions"

        binding.finishBtn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }




    }
}
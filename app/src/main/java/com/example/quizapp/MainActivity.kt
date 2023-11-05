package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener{



            if(binding.nameTxt.toString().isNotEmpty()){
                val name = binding.nameTxt.text.toString()
                startActivity(Intent(this, QuestionsActivity::class.java).putExtra(Constants.USER_NAME, name))
            }else{
                Toast.makeText(this, "Name field is empty", Toast.LENGTH_LONG).show()
            }


        }
    }
}
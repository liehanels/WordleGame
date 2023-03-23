package com.example.wordlegame

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HowToPlay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_to_play)
        var tip = "You have 5 tries to guess the five-letter word generated.\n" +
                  "1.\tType in a single character per box. <TAB> key moves to next box\n" +
                  "2.\tOnce the row is completed, click on the <Guess Row> button\n" +
                  "3.\tThe case of the characters will change after you submit your word.\n" +
                  "\t3.a\tUppercase means the letter is correct and in the right spot !\n" +
                  "\t3.b\tLowercase means the letter is in the word, but its position is somewhere else\n" +
                  "\t3.c\tDashes \' - \' replace incorrect letters\n" +
                  "4.\tContinue until you solve the word or run out of guesses.\n" +
                  "5.\tThe <Reset Game> button clears the game and changes the word.\n" +
                  "Good luck !"
        var lbl :TextView = findViewById(R.id.lblExplain)
        lbl.text = tip
        var back :Button = findViewById(R.id.btnBack)
        back.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
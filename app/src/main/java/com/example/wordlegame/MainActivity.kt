package com.example.wordlegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.ui.AppBarConfiguration

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        //buttons
        var guessButton :Button = findViewById(R.id.btnGuess)
        var how2PlayButton :Button = findViewById(R.id.btnHowToPlay)
        var resetButton :Button = findViewById(R.id.btnReset)
        //textView
        var titleLabel :TextView = findViewById(R.id.txtTitle)
        //editText - the whole damn grid
        var L1R1txf :EditText = findViewById(R.id.txtL1R1)
        var L2R1txf :EditText = findViewById(R.id.txtL2R1)
        var L3R1txf :EditText = findViewById(R.id.txtL3R1)
        var L4R1txf :EditText = findViewById(R.id.txtL4R1)
        var L5R1txf :EditText = findViewById(R.id.txtL5R1)
        var L1R2txf :EditText = findViewById(R.id.txtL1R2)
        var L2R2txf :EditText = findViewById(R.id.txtL2R2)
        var L3R2txf :EditText = findViewById(R.id.txtL3R2)
        var L4R2txf :EditText = findViewById(R.id.txtL4R2)
        var L5R2txf :EditText = findViewById(R.id.txtL5R2)
        var L1R3txf :EditText = findViewById(R.id.txtL1R3)
        var L2R3txf :EditText = findViewById(R.id.txtL2R3)
        var L3R3txf :EditText = findViewById(R.id.txtL3R3)
        var L4R3txf :EditText = findViewById(R.id.txtL4R3)
        var L5R3txf :EditText = findViewById(R.id.txtL5R3)
        var L1R4txf :EditText = findViewById(R.id.txtL1R4)
        var L2R4txf :EditText = findViewById(R.id.txtL2R4)
        var L3R4txf :EditText = findViewById(R.id.txtL3R4)
        var L4R4txf :EditText = findViewById(R.id.txtL4R4)
        var L5R4txf :EditText = findViewById(R.id.txtL5R4)
        var L1R5txf :EditText = findViewById(R.id.txtL1R5)
        var L2R5txf :EditText = findViewById(R.id.txtL2R5)
        var L3R5txf :EditText = findViewById(R.id.txtL3R5)
        var L4R5txf :EditText = findViewById(R.id.txtL4R5)
        var L5R5txf :EditText = findViewById(R.id.txtL5R5)
        //lists
        var guesses = mutableListOf<String>()
        var currentRow = mutableListOf<String>()
        //other vars
        var attempt = 0
        var game = GameEngine()
        //methods
        fun addAttempt(result :String, attempt :Int){
            if(attempt == 0){
                L1R5txf.setText(result[0].toString())
                //L1R5txf set edit false?
                L2R5txf.setText(result[1].toString())
                L3R5txf.setText(result[2].toString())
                L4R5txf.setText(result[3].toString())
                L5R5txf.setText(result[4].toString())
            }
            else if(attempt == 1){
                L1R4txf.setText(result[0].toString())
                L2R4txf.setText(result[1].toString())
                L3R4txf.setText(result[2].toString())
                L4R4txf.setText(result[3].toString())
                L5R4txf.setText(result[4].toString())
            }
            else if(attempt == 2){
                L1R3txf.setText(result[0].toString())
                L2R3txf.setText(result[1].toString())
                L3R3txf.setText(result[2].toString())
                L4R3txf.setText(result[3].toString())
                L5R3txf.setText(result[4].toString())
            }
            else if(attempt == 3){
                L1R2txf.setText(result[0].toString())
                L2R2txf.setText(result[1].toString())
                L3R2txf.setText(result[2].toString())
                L4R2txf.setText(result[3].toString())
                L5R2txf.setText(result[4].toString())
            }
            else if(attempt == 4){
                L1R1txf.setText(result[0].toString())
                L2R1txf.setText(result[1].toString())
                L3R1txf.setText(result[2].toString())
                L4R1txf.setText(result[3].toString())
                L5R1txf.setText(result[4].toString())
            }
        }
        fun clearFirstRow(){
            L1R1txf.setText("")
            L2R1txf.setText("")
            L3R1txf.setText("")
            L4R1txf.setText("")
            L5R1txf.setText("")
            L1R1txf.requestFocus()
        }
        //now for the app to actually do stuff
            //game.generateWords() y no working
        game.getRandomWord()
        Toast.makeText(this, "Start guessing !!!!", Toast.LENGTH_LONG).show()
        L1R1txf.requestFocus()
        //button actions
        resetButton.setOnClickListener(){
            game.getRandomWord()
            attempt = 0
            guesses.clear()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Game has been reset !", Toast.LENGTH_SHORT).show()
        }
        how2PlayButton.setOnClickListener(){
            val intent = Intent(this, HowToPlay::class.java)
            startActivity(intent)
        }
        guessButton.setOnClickListener(){
            if(attempt < 5){
                currentRow.add(0, L1R1txf.text.toString())
                currentRow.add(1, L2R1txf.text.toString())
                currentRow.add(2, L3R1txf.text.toString())
                currentRow.add(3, L4R1txf.text.toString())
                currentRow.add(4, L5R1txf.text.toString())
                guesses.add(currentRow[0]+currentRow[1]+currentRow[2]+currentRow[3]+currentRow[4])
                currentRow.clear()
                var guessNo = guesses[attempt] + " is guess number " + (attempt+1)
                Toast.makeText(this, guessNo, Toast.LENGTH_SHORT).show()
                var result = game.compareGuess(guesses[attempt])
                addAttempt(result, attempt)
                Toast.makeText(this, result.substring(5), Toast.LENGTH_LONG).show()
                attempt++
                if(attempt < 5){clearFirstRow()}
            }
            else {
                Toast.makeText(this, "Game Over ! Try again ^.^", Toast.LENGTH_LONG).show()
                var word = game.getCurrentWord()
                Toast.makeText(this, "The Word you were looking for was $word", Toast.LENGTH_LONG).show()
            }
        }
    }
}
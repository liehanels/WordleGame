package com.example.wordlegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        //buttons
        val guessButton :Button = findViewById(R.id.btnGuess)
        val how2PlayButton :Button = findViewById(R.id.btnHowToPlay)
        val resetButton :Button = findViewById(R.id.btnReset)
        //textView
        var titleLabel :TextView = findViewById(R.id.txtTitle)
        //editText - the whole damn grid
        var L1R1txf :EditText = findViewById(R.id.txtL1R1)
        var L2R1txf :EditText = findViewById(R.id.txtL2R1)
        var L3R1txf :EditText = findViewById(R.id.txtL3R1)
        var L4R1txf :EditText = findViewById(R.id.txtL4R1)
        var L5R1txf :EditText = findViewById(R.id.txtL5R1)

        var L1R2txf :EditText = findViewById(R.id.txtL1R2)
        L1R2txf.visibility = View.GONE
        var L2R2txf :EditText = findViewById(R.id.txtL2R2)
        L2R2txf.visibility = View.GONE
        var L3R2txf :EditText = findViewById(R.id.txtL3R2)
        L3R2txf.visibility = View.GONE
        var L4R2txf :EditText = findViewById(R.id.txtL4R2)
        L4R2txf.visibility = View.GONE
        var L5R2txf :EditText = findViewById(R.id.txtL5R2)
        L5R2txf.visibility = View.GONE

        var L1R3txf :EditText = findViewById(R.id.txtL1R3)
        L1R3txf.visibility = View.GONE
        var L2R3txf :EditText = findViewById(R.id.txtL2R3)
        L2R3txf.visibility = View.GONE
        var L3R3txf :EditText = findViewById(R.id.txtL3R3)
        L3R3txf.visibility = View.GONE
        var L4R3txf :EditText = findViewById(R.id.txtL4R3)
        L4R3txf.visibility = View.GONE
        var L5R3txf :EditText = findViewById(R.id.txtL5R3)
        L5R3txf.visibility = View.GONE

        var L1R4txf :EditText = findViewById(R.id.txtL1R4)
        L1R4txf.visibility = View.GONE
        var L2R4txf :EditText = findViewById(R.id.txtL2R4)
        L2R4txf.visibility = View.GONE
        var L3R4txf :EditText = findViewById(R.id.txtL3R4)
        L3R4txf.visibility = View.GONE
        var L4R4txf :EditText = findViewById(R.id.txtL4R4)
        L4R4txf.visibility = View.GONE
        var L5R4txf :EditText = findViewById(R.id.txtL5R4)
        L5R4txf.visibility = View.GONE

        var L1R5txf :EditText = findViewById(R.id.txtL1R5)
        L1R5txf.visibility = View.GONE
        var L2R5txf :EditText = findViewById(R.id.txtL2R5)
        L2R5txf.visibility = View.GONE
        var L3R5txf :EditText = findViewById(R.id.txtL3R5)
        L3R5txf.visibility = View.GONE
        var L4R5txf :EditText = findViewById(R.id.txtL4R5)
        L4R5txf.visibility = View.GONE
        var L5R5txf :EditText = findViewById(R.id.txtL5R5)
        L5R5txf.visibility = View.GONE
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
                L2R5txf.setText(result[1].toString())
                L3R5txf.setText(result[2].toString())
                L4R5txf.setText(result[3].toString())
                L5R5txf.setText(result[4].toString())
                L1R5txf.visibility = View.VISIBLE
                L2R5txf.visibility = View.VISIBLE
                L3R5txf.visibility = View.VISIBLE
                L4R5txf.visibility = View.VISIBLE
                L5R5txf.visibility = View.VISIBLE
            }
            else if(attempt == 1){
                L1R4txf.setText(result[0].toString())
                L2R4txf.setText(result[1].toString())
                L3R4txf.setText(result[2].toString())
                L4R4txf.setText(result[3].toString())
                L5R4txf.setText(result[4].toString())
                L1R4txf.visibility = View.VISIBLE
                L2R4txf.visibility = View.VISIBLE
                L3R4txf.visibility = View.VISIBLE
                L4R4txf.visibility = View.VISIBLE
                L5R4txf.visibility = View.VISIBLE
            }
            else if(attempt == 2){
                L1R3txf.setText(result[0].toString())
                L2R3txf.setText(result[1].toString())
                L3R3txf.setText(result[2].toString())
                L4R3txf.setText(result[3].toString())
                L5R3txf.setText(result[4].toString())
                L1R3txf.visibility = View.VISIBLE
                L2R3txf.visibility = View.VISIBLE
                L3R3txf.visibility = View.VISIBLE
                L4R3txf.visibility = View.VISIBLE
                L5R3txf.visibility = View.VISIBLE
            }
            else if(attempt == 3){
                L1R2txf.setText(result[0].toString())
                L2R2txf.setText(result[1].toString())
                L3R2txf.setText(result[2].toString())
                L4R2txf.setText(result[3].toString())
                L5R2txf.setText(result[4].toString())
                L1R2txf.visibility = View.VISIBLE
                L2R2txf.visibility = View.VISIBLE
                L3R2txf.visibility = View.VISIBLE
                L4R2txf.visibility = View.VISIBLE
                L5R2txf.visibility = View.VISIBLE
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
                Toast.makeText(this, guessNo+"", Toast.LENGTH_SHORT).show()
                var result = game.compareGuess(guesses[attempt])
                addAttempt(result.substring(0, 5), attempt)
                Toast.makeText(this, result.substring(5), Toast.LENGTH_LONG).show()
                attempt++
                if(attempt < 5){clearFirstRow()}
            }
            if (attempt > 4){
                var word = game.getCurrentWord()
                var titleT = "Word was $word"
                titleLabel.text = titleT
                Toast.makeText(this, "Game Over ! Tap 'Reset Game' to try again ^.^", Toast.LENGTH_LONG).show()
                resetButton.requestFocus()
            }
        }
    }
}
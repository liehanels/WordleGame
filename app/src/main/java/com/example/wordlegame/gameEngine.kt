package com.example.wordlegame
import android.widget.Toast
import java.io.File
import kotlin.math.roundToInt
class GameEngine {
    private var wordsList = mutableListOf<String>("upset","sweat","worry","clock","coast","trade","carve",
        "north","sting","motif","panel","basin","equal","treat","ferry","colon","catch","worth","Koran","march",
        "prize","knife","alarm","river","trick","yearn","award","miner","witch","brink","blame","raise","floor","issue","tempt")
    private var currentWord = ""
    public fun generateWords(){
        //File("com/example/wordlegame/words.txt").useLines { lines -> wordsList.addAll(lines) }
    }
    public fun getRandomWord() {
        var number = (Math.random()*34).roundToInt()
        currentWord = wordsList[number]
    }
    public fun compareGuess(guess :String): String {
        var resultList = mutableListOf<String>()
        var i = 0
        var pos = 0
        var cont = 0
        var w = 0
        var msg = ""
        var result = ""
        var output = ""
        while(i < 5){
            if(guess.uppercase() == currentWord.uppercase()){
                repeat(5){
                    resultList.add(w, guess)
                    w++
                }
                msg = "You got it !!! Well done !"
                i = 5
            }
            else if(currentWord.contains(guess[i])) {
                if (currentWord[i] == guess[i]) {
                    resultList.add(i, guess[i].toString().uppercase())
                    pos++
                    i++
                    msg = "It seems as if you had $pos letters on the right place, $cont other letters that are in the word, but not in the correct position"
                } else {
                    resultList.add(i, guess[i].toString().lowercase())
                    cont++
                    i++
                    msg = "It seems as if you had $pos letters on the right place, $cont other letters that are in the word, but not in the correct position"
                }
            }
            else{
                    resultList.add(i, "-")
                    i++
                    msg = "It seems as if you had $pos letters on the right place, $cont other letters that are in the word, but not in the correct position"
                }
        }
        result = ""
        output = ""
        result = resultList[0] + resultList[1] + resultList[2] + resultList[3] + resultList[4]
        output = result + msg
        resultList.clear()
        return output
    }
}
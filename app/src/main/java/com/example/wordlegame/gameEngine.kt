package com.example.wordlegame
import kotlin.math.roundToInt
class GameEngine {
    private var wordsList = mutableListOf("upset","sweat","worry","clock","coast","trade","carve",
        "north","sting","motif","panel","basin","equal","treat","ferry","colon","catch","worth","Koran","march",
        "prize","knife","alarm","river","trick","yearn","award","miner","witch","brink","blame","raise","floor","issue","tempt","apply")
    private var currentWord = ""
    fun getRandomWord() {
        var number = (Math.random()*35).roundToInt()
        currentWord = ""
        currentWord = wordsList[number]
    }
    fun getCurrentWord(): String {return this.currentWord}
    fun compareGuess(guess :String): String {
        var resultList = mutableListOf<String>()
        var i = 0
        var pos = 0
        var cont = 0
        var msg = ""
        var result = ""
        var output = ""
        if(guess.uppercase() == currentWord.uppercase()){
            repeat(5){
                resultList.add(i, guess[i].uppercase()+"")
                i++
            }
            msg = "You got it ( $guess ) !!! Well done !"
        }
        else if(i != 0){
            while (i < 5) {
                if (currentWord[i] == guess[i]) {
                    resultList.add(i, guess[i].toString().uppercase())
                    pos++
                    i++
                } else if (currentWord.contains(guess[i])) {
                    resultList.add(i, guess[i].toString().lowercase())
                    cont++
                    i++
                } else {
                    resultList.add(i, "-")
                    i++
                }
            }
            msg = "It seems as if you had $pos letters on the right place, $cont other letters that are in the word, but not in the correct position"
        }
        result = resultList[0] + resultList[1] + resultList[2] + resultList[3] + resultList[4]
        output = result + msg
        resultList.clear()
        return output
    }
}
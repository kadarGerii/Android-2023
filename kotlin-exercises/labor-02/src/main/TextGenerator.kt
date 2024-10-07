package main

import kotlin.random.Random

object TextGenerator {
    val storedWords = mutableMapOf<Pair <String, String>, MutableList<String>>()

    fun learnWords(text:String): Unit {
        storedWords.clear()
        if (text == ""){
            return
        }
        val wordsSplited = text.split(" ")
        for (i in 0 until wordsSplited.size - 2){
            val prefix = Pair(wordsSplited[i], wordsSplited[i+1])
            val postfix = wordsSplited[i+2];

//            println("prefix: $prefix, postfix: $postfix")

            storedWords.getOrPut(prefix) { mutableListOf() }.add(postfix)
        }
    }

    fun generateText(): String {
        if (storedWords.isEmpty()){
            return ""
        }
        val firstWords = storedWords.keys.first()
        val generatedText = mutableListOf(firstWords.first, firstWords.second)

        var currentPrefix = firstWords
        var postfixes = storedWords[currentPrefix]

        while(!postfixes.isNullOrEmpty()){
            val nextWord = postfixes[Random.nextInt(postfixes.size)]
            generatedText.add(nextWord)

            currentPrefix = Pair(currentPrefix.second, nextWord)

            if (!storedWords.containsKey(currentPrefix)){
                break
            }

            postfixes = storedWords[currentPrefix]
        }

        return generatedText.joinToString(" ")
    }
}
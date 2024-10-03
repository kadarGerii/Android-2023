package main

import java.io.File

class ListDictionary() : IDictionary {
    val words: MutableList<String> = mutableListOf()

    init {
        try {
            File("dict.txt").forEachLine { line ->
                words.add(line.trim())
            }
        } catch (e: Exception) {
            println("Error reading from file: ${e.message}")
        }
    }

    override fun add (word:String): Boolean{
        if (words.contains(word)){
            return false;
        }
        words.add(word);
        return true;
    }

    override fun find(word: String): Boolean {
        return words.contains(word);
    }

    override fun size(): Int {
        return words.size
    }
}
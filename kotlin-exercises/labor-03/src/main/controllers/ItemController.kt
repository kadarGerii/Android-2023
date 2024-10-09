package main.controllers

import main.services.ItemService

class ItemController {
    val itemService = ItemService()

    fun quiz(number: Int): Unit {
        val items = itemService.selectRandomItem(number)
        var correctAnswers = 0

        for (item in items) {
            println(item.question)
            item.answers.forEachIndexed({ index, answer -> println("${index + 1}. $answer") })
            var answer = 0
            while ( true) {
                print("Your answer: ")
                answer = readLine()!!.toInt()
                if (answer in 1..item.answers.size) {
                    break
                }
                println("Invalid answer! Please try again.")
            }

            if (answer == item.correct+1) {
                correctAnswers++
            }
        }

        println("You got $correctAnswers/$number correct!")
    }
}
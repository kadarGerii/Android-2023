package main

import main.controllers.ItemController

fun main(args: Array<String>) {

    val itemController = ItemController()
    println("How many questions do you want?")
    while (true) {
        print("> ")
        val number = readLine()!!.toInt()
        try {
            itemController.quiz(number)
            break
        } catch (e: Exception) {
            println("Invalid input")

        }
    }
}